//package Hari.adobe.aem.guides.core.datasource;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ResourceMetadata;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.api.resource.ValueMap;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.Self;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//import com.adobe.cq.commerce.common.ValueMapDecorator;
//import com.adobe.granite.ui.components.ds.DataSource;
//import com.adobe.granite.ui.components.ds.SimpleDataSource;
//import com.adobe.granite.ui.components.ds.ValueMapResource;
//import com.day.cq.wcm.api.Page;
//import com.day.cq.wcm.api.PageManager;
//
//@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class ChildPagesDataSource {
//
//    @Self
//    private Resource resource;
//
//    @ValueMapValue
//    private String parentPagePath;
//
//    @PostConstruct
//    protected void init() {
//        ResourceResolver resourceResolver = resource.getResourceResolver();
//        List<Resource> childPageResources = new ArrayList<>();
//
//        if (parentPagePath != null && !parentPagePath.isEmpty()) {
//            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//            
//          //  Page parentPage = pageManager.getPage(parentPagePath);
//            Page parentPage = pageManager.getPage(parentPagePath);
//
//            if (parentPage != null) {
//                Iterator<Page> childIterator = parentPage.listChildren();
//                while (childIterator.hasNext()) {
//                    Page childPage = childIterator.next();
//                    ValueMap valueMap = new ValueMapDecorator(new HashMap<>());
//                    valueMap.put("value", childPage.getPath());
//                    valueMap.put("text", childPage.getPath());
//
//                    Resource childPageResource = new ValueMapResource(resourceResolver, new ResourceMetadata(), "nt:unstructured", valueMap);
//                    childPageResources.add(childPageResource);
//                }
//            }
//        }
//
//        DataSource dataSource = new SimpleDataSource(childPageResources.iterator());
//        resource.adaptTo(ValueMap.class).put(DataSource.class.getName(), dataSource);
//    }
//}
