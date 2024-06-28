package Hari.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CorouselSlingmodelExTest {

    @Mock
    private Resource details;

    @Mock
    private Resource childResource1;

    @Mock
    private Resource childResource2;
 
    @InjectMocks
    private CorouselSlingmodelEx corouselSlingmodelEx;

    @BeforeEach
    void setUp() {
        ValueMap valueMap1 = mock(ValueMap.class);
        when(valueMap1.get("firstname", String.class)).thenReturn("John");
        when(valueMap1.get("pathfield", String.class)).thenReturn("/content/path1");
        when(valueMap1.get("address", String[].class)).thenReturn(new String[]{"Address1"});

        ValueMap valueMap2 = mock(ValueMap.class);
        when(valueMap2.get("firstname", String.class)).thenReturn("Jane");
        when(valueMap2.get("pathfield", String.class)).thenReturn("/content/path2");
        when(valueMap2.get("address", String[].class)).thenReturn(new String[]{"Address2"});

        when(childResource1.getValueMap()).thenReturn(valueMap1);
        when(childResource2.getValueMap()).thenReturn(valueMap2);

        Iterable<Resource> iterable = Arrays.asList(childResource1, childResource2);
        when(details.getChildren()).thenReturn(iterable);
    }

    @Test
    void testGetDetails() {
        List<Map<String, Object>> result = corouselSlingmodelEx.getDetails();

        assertEquals(2, result.size());

        // Expected Child 1
        assertEquals("John", result.get(0).get("firstname"));
        assertEquals("/content/path1", result.get(0).get("pathfield"));
        assertEquals(Arrays.asList("Address1"), Arrays.asList((String[]) result.get(0).get("address")));

        // Expected Child 2
        assertEquals("Jane", result.get(1).get("firstname"));
        assertEquals("/content/path2", result.get(1).get("pathfield"));
        assertEquals(Arrays.asList("Address2"), Arrays.asList((String[]) result.get(1).get("address")));
    }
}
