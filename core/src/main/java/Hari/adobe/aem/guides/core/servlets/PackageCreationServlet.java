package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.vault.fs.api.PathFilterSet;
import org.apache.jackrabbit.vault.fs.config.DefaultWorkspaceFilter;
import org.apache.jackrabbit.vault.fs.io.ImportOptions;
import org.apache.jackrabbit.vault.packaging.JcrPackage;
import org.apache.jackrabbit.vault.packaging.JcrPackageDefinition;
import org.apache.jackrabbit.vault.packaging.JcrPackageManager;
import org.apache.jackrabbit.vault.packaging.PackageException;
import org.apache.jackrabbit.vault.packaging.Packaging;
import org.apache.jackrabbit.vault.util.DefaultProgressListener;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = javax.servlet.Servlet.class)
@SlingServletPaths(value = { "/bin/package" })
public class PackageCreationServlet extends SlingAllMethodsServlet {

    @Reference
    private Packaging packaging;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        Session session = request.getResourceResolver().adaptTo(Session.class);
        if (session == null) {
            response.getWriter().write("Session not available");
            return;
        }

        JcrPackage jcrPackage = null;
        InputStream inputStream = null;
        try {
            // Create package
            JcrPackageManager packageManager = packaging.getPackageManager(session);
            jcrPackage = packageManager.create("my-packages", "my-package", "1.0");
            if (jcrPackage == null) {
                response.getWriter().write("Package creation failed");
                return;
            }

            // Define package filters
            DefaultWorkspaceFilter filter = new DefaultWorkspaceFilter();
            PathFilterSet filterSet = new PathFilterSet("/apps/Hari/components/mixed");
            filter.add(filterSet);
            JcrPackageDefinition packageDefinition = jcrPackage.getDefinition();
            if (packageDefinition != null) {
                packageDefinition.setFilter(filter, true);

                ImportOptions opts = new ImportOptions();
                packageManager.assemble(jcrPackage, new DefaultProgressListener());
            }

            // Save and close the package
           

            // Reopen the package to ensure it's saved and accessible
            jcrPackage = packageManager.open(jcrPackage.getNode());
            if (jcrPackage == null || jcrPackage.getData() == null) {
                response.getWriter().write("Package reopening failed");
                return;
            }

            // Get input stream for package data
            inputStream = jcrPackage.getData().getBinary().getStream();

            // Set response headers for downloading
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=my-package.zip");

            // Write package data to response output stream
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
        } catch (RepositoryException | IOException | PackageException e) {
            response.getWriter().write("Error while creating or downloading the package: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (jcrPackage != null) {
                jcrPackage.close();
            }
            
            
            session.logout();
        }
    }
}
