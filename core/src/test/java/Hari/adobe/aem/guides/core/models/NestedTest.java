package Hari.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class NestedTest {

    private final Resource resource = mock(Resource.class);
    private Nested underTest;

    @BeforeEach
    void setUp() {
        // Mock the ValueMap with the expected 'navigation' value
        ValueMap valueMap = mock(ValueMap.class);
        when(valueMap.get("navigation", String.class)).thenReturn("Home > Products > New");

        // Mock the Resource to return the mocked ValueMap
        when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);

        // Instantiate the model with the mocked Resource
        underTest = new Nested();
        underTest.navigation = resource.adaptTo(ValueMap.class).get("navigation", String.class);
    }

    @Test
    void testGetNavigation() {
        // Test the getNavigation method
        String expected = "Home > Products > New";
        String actual = underTest.getNavigation();
        assertEquals(expected, actual, "The navigation property did not match the expected value");
    }
}
