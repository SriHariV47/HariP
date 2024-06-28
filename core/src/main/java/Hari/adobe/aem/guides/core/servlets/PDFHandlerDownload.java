//package Hari.adobe.aem.guides.core.servlets;
//
//import java.io.IOException;
//import javax.servlet.Servlet;
//import javax.servlet.ServletException;
//
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.servlets.SlingAllMethodsServlet;
//import org.apache.sling.servlets.annotations.SlingServletPaths;
//import org.osgi.service.component.annotations.Component;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//
//@Component(service = Servlet.class)
//@SlingServletPaths(value = "/bin/mypdfhandler/sdfgoiuytre")
//public class PDFHandlerDownload extends SlingAllMethodsServlet {
//
//    @Override
//    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//                contentStream.beginText();
//                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//                contentStream.newLineAtOffset(100, 700);
//                contentStream.showText("This is a generated PDF document.");
//                contentStream.endText();
//            }
//
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=generated.pdf");
//            
//            document.save(response.getOutputStream());
//        } catch (Exception e) {
//            response.sendError(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }
//}
