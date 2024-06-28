//package Hari.adobe.aem.guides.core.servlets;
//
//import static org.junit.Assert.assertTrue;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.lenient;
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
//class ExcelTest {
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
//        lenient().when(request.getRequestParameter("selectedfile")).thenReturn(requestParameter);
//        lenient().when(resourceResolver.getResource(anyString())).thenReturn(resource);
//        lenient().when(resource.adaptTo(Node.class)).thenReturn(node);
//        lenient().when(node.getProperties()).thenReturn(propertyIterator);
//        lenient().when(propertyIterator.hasNext()).thenReturn(true, false);
//        lenient().when(propertyIterator.nextProperty()).thenReturn(property);
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
//        // Creating an empty workbook
//        try (Workbook workbook = new XSSFWorkbook()) {
//            ByteArrayInputStream bis = getWorkbookInputStream(workbook);
//            when(requestParameter.getInputStream()).thenReturn(bis);
//
//            // Calling the doPost method
//            excelServlet.doPost(request, response);
//            pw.flush();
//
//            // Asserting the response
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
//        ExcelTest.executeQuery(multiFieldslist, headerFields, request, response);
//        pw.flush();
//
//        assert sw.toString().contains("Value");
//    }
//
//    
//    private static void executeQuery(List<String> multiFieldslist, List<String> headerFields,
//			SlingHttpServletRequest request2, SlingHttpServletResponse response2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//    @Test
//    void testAddProperties() throws RepositoryException, IOException {
//        // Create the mocks and stubs
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//
//        when(response.getWriter()).thenReturn(pw);
//        when(resourceResolver.adaptTo(Session.class)).thenReturn(session);
//        when(resource.adaptTo(ModifiableValueMap.class)).thenReturn(properties);
//
//        // Prepare input data for the test
//        List<String> multiFieldslist = List.of("MultiField1", "MultiField2");
//        when(properties.containsKey("MultiField1")).thenReturn(false);
//        when(properties.containsKey("MultiField2")).thenReturn(false);
//
//        // Call the method under test
//        excelServlet.addproperties(multiFieldslist, Collections.singletonMap("testKey", "testValue"), request, response);
//        pw.flush();
//
//        // Verify the interactions and the state
//        verify(properties).put("testKey", new String[]{"testValue"});
//        verify(session).save();
//
//        String responseContent = sw.toString();
//        assertTrue(responseContent.contains("Properties updated successfully."));
//    }
//
//
//
//}
