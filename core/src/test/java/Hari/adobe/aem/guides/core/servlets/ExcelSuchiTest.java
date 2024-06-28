//package Hari.adobe.aem.guides.core.servlets;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.util.Collections;
//import java.util.List;
//
//import javax.jcr.Node;
//import javax.jcr.Property;
//import javax.jcr.PropertyIterator;
//import javax.jcr.RepositoryException;
//import javax.jcr.Session;
//import javax.servlet.ServletException;
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.request.RequestParameter;
//import org.apache.sling.api.resource.ModifiableValueMap;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class ExcelSuchiTest {
//
//    @InjectMocks
//    private Excel excelServlet;
//
//    @Mock
//    private SlingHttpServletRequest request;
//
//    @Mock
//    private SlingHttpServletResponse response;
//
//    @Mock
//    private ResourceResolver resourceResolver;
//
//    @Mock
//    private RequestParameter requestParameter;
//
//    @Mock
//    private Resource resource;
//
//    @Mock
//    private Node node;
//
//    @Mock
//    private PropertyIterator propertyIterator;
//
//    @Mock
//    private Property property;
//
//    @Mock
//    private Session session;
//
//    @Mock
//    private ModifiableValueMap properties;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        when(request.getResourceResolver()).thenReturn(resourceResolver);
//        when(request.getRequestParameter("selectedfile")).thenReturn(requestParameter);
//        when(resourceResolver.getResource(anyString())).thenReturn(resource);
//        when(resource.adaptTo(Node.class)).thenReturn(node);
//        when(node.getProperties()).thenReturn(propertyIterator);
//        when(propertyIterator.hasNext()).thenReturn(true, false);
//        when(propertyIterator.nextProperty()).thenReturn(property);
//    }
//
//    private ByteArrayInputStream getWorkbookInputStream(Workbook workbook) throws IOException {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        workbook.write(bos);
//        return new ByteArrayInputStream(bos.toByteArray());
//    }
//
//    @Test
//    void testDoPostEmptyHeader() throws ServletException, IOException {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        when(response.getWriter()).thenReturn(pw);
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            ByteArrayInputStream bis = getWorkbookInputStream(workbook);
//            when(requestParameter.getInputStream()).thenReturn(bis);
//
//            excelServlet.doPost(request, response);
//            pw.flush();
//
//            assert sw.toString().contains("Excel file has no header row.");
//        }
//    }
//
//    @Test
//    void testDoPostNoRequiredFields() throws ServletException, IOException {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        when(response.getWriter()).thenReturn(pw);
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            workbook.createSheet().createRow(0).createCell(0).setCellValue("Header");
//            ByteArrayInputStream bis = getWorkbookInputStream(workbook);
//            when(requestParameter.getInputStream()).thenReturn(bis);
//
//            excelServlet.doPost(request, response);
//            pw.flush();
//
//            assert sw.toString().contains("No required fields found in the Excel header.");
//        }
//    }
//
//    @Test
//    void testDoPostMissingFields() throws ServletException, IOException {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        when(response.getWriter()).thenReturn(pw);
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            workbook.createSheet().createRow(0).createCell(0).setCellValue("Header*");
//            workbook.getSheetAt(0).createRow(1).createCell(0).setCellValue("");
//            ByteArrayInputStream bis = getWorkbookInputStream(workbook);
//            when(requestParameter.getInputStream()).thenReturn(bis);
//
//            excelServlet.doPost(request, response);
//            pw.flush();
//
//            assert sw.toString().contains("Missing required fields:");
//        }
//    }
//
//    @Test
//    void testDoPostWithValidData() throws ServletException, IOException, RepositoryException {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        when(response.getWriter()).thenReturn(pw);
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            workbook.createSheet().createRow(0).createCell(0).setCellValue("Header*");
//            workbook.getSheetAt(0).createRow(1).createCell(0).setCellValue("Valid Data");
//            ByteArrayInputStream bis = getWorkbookInputStream(workbook);
//            when(requestParameter.getInputStream()).thenReturn(bis);
//
//            when(resourceResolver.findResources(anyString(), anyString())).thenReturn(List.of(resource).iterator());
//            when(node.getProperty("name")).thenReturn(property);
//            when(node.getProperty("fieldLabel")).thenReturn(property);
//            when(property.getString()).thenReturn("Value");
//
//            excelServlet.doPost(request, response);
//            pw.flush();
//
//            assert sw.toString().contains("Got the data");
//        }
//    }
//
//    @Test
//    void testExecuteQuery() throws IOException, RepositoryException {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        when(response.getWriter()).thenReturn(pw);
//
//        List<String> multiFieldslist = List.of("MultiField1", "MultiField2");
//        List<String> headerFields = List.of("Header1", "Header2");
//
//        when(resourceResolver.findResources(anyString(), anyString())).thenReturn(Collections.singletonList(resource).iterator());
//        when(node.getProperty("name")).thenReturn(property);
//        when(node.getProperty("fieldLabel")).thenReturn(property);
//        when(property.getString()).thenReturn("Value");
//
//        excelServlet.executeQuery(multiFieldslist, headerFields, request, response);
//        pw.flush();
//
//        assert sw.toString().contains("Value");
//    }
//
//    @Test
//    void testAddProperties() throws RepositoryException, IOException {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        when(response.getWriter()).thenReturn(pw);
//        when(resourceResolver.adaptTo(Session.class)).thenReturn(session);
//        when(resource.adaptTo(ModifiableValueMap.class)).thenReturn(properties);
//
//        List<String> multiFieldslist = List.of("MultiField1", "MultiField2");
//        when(properties.containsKey("MultiField1")).thenReturn(false);
//        when(properties.containsKey("MultiField2")).thenReturn(false);
//
//        excelServlet.addproperties(multiFieldslist, Collections.singletonMap("testKey", "testValue"), request, response);
//        pw.flush();
//
//        verify(properties).put("testKey", new String[]{"testValue"});
//        verify(session).save();
//        assert sw.toString().contains("Properties updated successfully.");
//    }
//}
