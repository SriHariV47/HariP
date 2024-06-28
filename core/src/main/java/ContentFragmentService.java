

import org.apache.sling.api.resource.ResourceResolver;

public interface ContentFragmentService {
    String getFragmentContent(String path,ResourceResolver resourceResolver);
}