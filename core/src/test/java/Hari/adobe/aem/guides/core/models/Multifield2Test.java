package Hari.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Multifield2Test {

    @Mock
    private Resource resource;

    @Mock
    private ModelFactory modelFactory;

    private Multifield2 multifield2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        multifield2 = new Multifield2();
    }

    @Test
    public void testGetDesktopicon() {
        String desktopIcon = "desktop_icon_value";
        multifield2.icon = desktopIcon;
        assertEquals(desktopIcon, multifield2.getDesktopicon());
    }

    @Test
    public void testGetMobileicon() {
        String mobileIcon = "mobile_icon_value";
        multifield2.mobileicon = mobileIcon;
        assertEquals(mobileIcon, multifield2.getMobileicon());
    }

    @Test
    public void testGetNested() {
        List<Nested> nestedList = Collections.singletonList(new Nested());
        multifield2.nested = nestedList;
        assertEquals(nestedList, multifield2.getNested());
    }

    
}
