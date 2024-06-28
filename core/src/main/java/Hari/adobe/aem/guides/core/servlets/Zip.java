package Hari.adobe.aem.guides.core.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.jackrabbit.vault.fs.api.PathFilterSet;
import org.apache.jackrabbit.vault.fs.config.DefaultWorkspaceFilter;
import org.apache.jackrabbit.vault.fs.io.ImportOptions;
import org.apache.jackrabbit.vault.packaging.JcrPackage;
import org.apache.jackrabbit.vault.packaging.JcrPackageDefinition;
import org.apache.jackrabbit.vault.packaging.JcrPackageManager;
import org.apache.jackrabbit.vault.packaging.PackageException;
import org.apache.jackrabbit.vault.packaging.Packaging;
import org.apache.jackrabbit.vault.util.DefaultProgressListener;
import org.apache.oltu.oauth2.common.error.OAuthError.ResourceResponse;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@SuppressWarnings("serial")
@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=/bin/convertToZip"
        })
public class Zip extends SlingAllMethodsServlet {

    @Reference
    private Packaging packaging;

    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        // Component path
        String componentPath = "/apps/Hari/components/mixed";

        // Convert component path to a zip file
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        // Create package
        Session session = request.getResourceResolver().adaptTo(Session.class);
        if (session != null) {
            InputStream packageInputStream = createPackage(session, componentPath);
            if (packageInputStream != null) {
                addToZip(zos, "my-package.zip", packageInputStream);
            }
            session.logout();
        }
       
        zos.finish();
        zos.close();

        
        createPackage(session, componentPath);
        
        
        
        
        // Set response headers
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=my-package.zip");

        

        // Write zip file to response output stream
        OutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
    }

    private void addToZip(ZipOutputStream zos, String path, InputStream inputStream) throws IOException {
        // Add file to zip file
        zos.putNextEntry(new ZipEntry(path));

        // Write package content to zip output stream
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            zos.write(buffer, 0, bytesRead);
        }

        zos.closeEntry();
    }

    private InputStream createPackage(Session session, String componentPath) throws IOException {
        try {
            // Create package
            JcrPackageManager packageManager = packaging.getPackageManager(session);
            JcrPackage jcrPackage = packageManager.create("my-packages", "my-package", "1.0");
            if (jcrPackage == null) {
                return null;
            }

            // Define package filters
            DefaultWorkspaceFilter filter = new DefaultWorkspaceFilter();
            PathFilterSet filterSet = new PathFilterSet(componentPath);
            filter.add(filterSet);
            JcrPackageDefinition packageDefinition = jcrPackage.getDefinition();
            if (packageDefinition != null) {
                packageDefinition.setFilter(filter, true);

                ImportOptions opts = new ImportOptions();
                packageManager.assemble(jcrPackage, new DefaultProgressListener());
            }

            // Save and close the package
            jcrPackage.close();

            // Get package node and return input stream
            return jcrPackage.getData().getBinary().getStream();

        } catch (RepositoryException | PackageException e) {
            // Handle exception
            return null;
        }
    }
}