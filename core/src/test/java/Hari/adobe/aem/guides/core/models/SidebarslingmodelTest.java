package Hari.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SidebarslingmodelTest {

    private Sidebarslingmodel sidebarslingmodel;

    @BeforeEach
    public void setUp() {
        // Initialize the model and set the values
        sidebarslingmodel = new Sidebarslingmodel();
        sidebarslingmodel.logopathfield = "logo-path.png";
        sidebarslingmodel.logomobileimage = "logo-mobile.png";
        sidebarslingmodel.logolink = "http://example.com";
        sidebarslingmodel.checkbox = "true";
        sidebarslingmodel.country = "USA";

        // Mock child resources
        Resource childResource1 = mock(Resource.class);
        Multifield1 multifield1 = mock(Multifield1.class);
        List<Multifield1> day1List = Arrays.asList(multifield1);

        Resource childResource2 = mock(Resource.class);
        Multifield2 multifield2 = mock(Multifield2.class);
        List<Multifield2> day2List = Arrays.asList(multifield2);

        // Mock the resource and its child resources
        Resource resource = mock(Resource.class);
        when(resource.getChild("Day1")).thenReturn(childResource1);
        when(childResource1.adaptTo(List.class)).thenReturn(day1List);

        when(resource.getChild("Day2")).thenReturn(childResource2);
        when(childResource2.adaptTo(List.class)).thenReturn(day2List);

        // Set the child resources manually
        sidebarslingmodel.Day1 = day1List;
        sidebarslingmodel.Day2 = day2List;
    }

    @Test
    public void testGetLogopath() {
        assertEquals("logo-path.png", sidebarslingmodel.getLogopath());
    }

    @Test
    public void testGetLogomobileimage() {
        assertEquals("logo-mobile.png", sidebarslingmodel.getLogomobileimage());
    }

    @Test
    public void testGetLogolink() {
        assertEquals("http://example.com", sidebarslingmodel.getLogolink());
    }

    @Test
    public void testGetCheckbox() {
        assertEquals("true", sidebarslingmodel.getCheckbox());
    }

    @Test
    public void testGetCountry() {
        assertEquals("USA", sidebarslingmodel.getCountry());
    }

    @Test
    public void testGetDay1() {
        assertEquals(1, sidebarslingmodel.getDay1().size());
    }

    @Test
    public void testGetDay2() {
        assertEquals(1, sidebarslingmodel.getDay2().size());
    }
}
