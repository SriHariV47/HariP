package Hari.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Multifield1Test {

    private Multifield1 multifield1;
    
    @BeforeEach
    void setUp() {
        // Mock the Resource and ValueMap
        Resource resource = mock(Resource.class);
        ValueMap valueMap = mock(ValueMap.class);

        // Stubbing for the getValueMap() method of the mocked Resource
        when(resource.getValueMap()).thenReturn(valueMap);

        // Stubbing for the get() method of the mocked ValueMap
        when(valueMap.get("text", String.class)).thenReturn("Test Text");
        when(valueMap.get("image", String.class)).thenReturn("Test Image");

        // Instantiate Multifield1
        multifield1 = new Multifield1();
        
        // Set the fields directly
        multifield1.text = valueMap.get("text", String.class);
        multifield1.image = valueMap.get("image", String.class);
    }

    @Test
    void testGetName() {
        assertEquals("Test Text", multifield1.getName());
    }

    @Test
    void testGetImage() {
        assertEquals("Test Image", multifield1.getImage());
    }
}
