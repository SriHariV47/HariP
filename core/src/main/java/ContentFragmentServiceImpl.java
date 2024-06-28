



import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

public class ContentFragmentServiceImpl implements ContentFragmentService {

    @Override
    public String getFragmentContent(String path, ResourceResolver resourceResolver) {
        Resource resource = resourceResolver.getResource(path);
        if (resource != null) {
            return resource.getValueMap().get("content", String.class);
        }
        return "Content Fragment not found or no content available.";
    }
}