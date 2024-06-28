//package Hari.adobe.aem.guides.core.models;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ValueMap;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//class HeaderSlingmodelexTest {
//
//    @Mock
//    private Resource details;
//
//    @Mock
//    private Iterator<Resource> iterator;
//
//    @Mock
//    private Resource childResource;
//
//    @InjectMocks
//    private HeaderSlingmodelex model;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        // Mock the behavior of the details resource and its children
//        Iterable<Resource> iterable = mock(Iterable.class);
//        when(details.getChildren()).thenReturn(iterable);
//        when(iterable.iterator()).thenReturn(iterator);
//
//        when(iterator.hasNext()).thenReturn(true, false);
//        when(iterator.next()).thenReturn(childResource);
//
//        // Mock the value map of the child resource
//        ValueMap valueMap = mock(ValueMap.class);
//        when(childResource.getValueMap()).thenReturn(valueMap);
//        when(valueMap.get("firstname", String.class)).thenReturn("John Doe");
//        when(valueMap.get("dob", String.class)).thenReturn("01/01/1990");
//
//        // Initialize the model and set the details resource
//        model = new HeaderSlingmodelex();
//        model.details = details;
//    }
//
//    @Test
//    void testGetPathfield() {
//        model.pathfield = "sample/path";
//        assertEquals("sample/path", model.getPathfield());
//    }
//
//    @Test
//    void testGetCheckbox() {
//        model.checkbox = "on";
//        assertEquals("on", model.getCheckbox());
//        model.checkbox = "off";
//        assertEquals("off", model.getCheckbox());
//    }
//
//    @Test
//    void testGetText() {
//        model.text = "Sample Text";
//        assertEquals("Sample Text", model.getText());
//    }
//
//    @Test
//    void testGetDetails() {
//        List<Map<String, Object>> detailsList = model.getDetails();
//        assertEquals(1, detailsList.size());
//        Map<String, Object> detailsMap = detailsList.get(0);
//        assertEquals("John Doe", detailsMap.get("firstname"));
//        assertEquals("01/01/1990", detailsMap.get("dob"));
//    }
//}
