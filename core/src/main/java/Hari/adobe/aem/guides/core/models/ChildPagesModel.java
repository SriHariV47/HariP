package Hari.adobe.aem.guides.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ChildPagesModel {

    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String parentPagePath;

    private List<ChildPage> childPages;

    @PostConstruct
    protected void init() {
        if (parentPagePath == null || parentPagePath.isEmpty()) {
            childPages = Collections.emptyList();
            return;
        }

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page parentPage = pageManager.getPage(parentPagePath);

        if (parentPage == null) {
            childPages = Collections.emptyList();
            return;
        }

        childPages = new ArrayList<>();
        Iterator<Page> childIterator = parentPage.listChildren();
        while (childIterator.hasNext()) {
            Page childPage = childIterator.next();
            childPages.add(new ChildPage(childPage.getPath(), childPage.getTitle()));
        }
    }

    public List<ChildPage> getChildPages() {
        return childPages;
    }

    public String getChildPageTitles() {
        List<String> titles = new ArrayList<>();
        for (ChildPage childPage : childPages) {
            titles.add(childPage.getTitle());
        }
        return String.join(", ", titles);
    }

    public static class ChildPage {
        private final String path;
        private final String title;

        public ChildPage(String path, String title) {
            this.path = path;
            this.title = title;
        }

        public String getPath() {
            return path;
        }

        public String getTitle() {
            return title;
        }
    }
}
