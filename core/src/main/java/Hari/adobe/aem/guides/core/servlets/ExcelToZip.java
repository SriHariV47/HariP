package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@Component(
        service = {Servlet.class},
        property = {
                ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/zip/excelzip/sdfghjkjn",
                ServletResolverConstants.SLING_SERVLET_METHODS + "=POST"
        }
)
public class ExcelToZip extends SlingAllMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelToZip.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        // Get the collection of parts (files) from the request
        Collection<Part> fileParts = request.getParts();

        // Check if no files were uploaded
        if (fileParts.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("No files uploaded");
            return;
        }

        List<String> assetPaths = new ArrayList<>();

        try {
            for (Part filePart : fileParts) {
                InputStream inputStream = filePart.getInputStream();

                // Process the Excel file
                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                // Iterate through rows and fetch the value from the first column
                for (Row row : sheet) {
                    Cell firstCell = row.getCell(0); // Get the first cell of each row
                    if (firstCell != null) {
                        String assetPath = firstCell.getStringCellValue();
                        assetPaths.add(assetPath);
                    }
                }

                workbook.close();
                inputStream.close();
            }

            // Print asset paths
            for (String path : assetPaths) {
                response.getWriter().write(path + "\n");
            }

            // Send success response
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("\nFile uploaded successfully");
        } catch (Exception e) {
            LOGGER.error("Error uploading file", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error uploading File: " + e.getMessage());
        }
    }

}