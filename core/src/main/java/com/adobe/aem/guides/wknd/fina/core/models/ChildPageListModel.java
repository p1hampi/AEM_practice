package com.adobe.aem.guides.wknd.fina.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class ChildPageListModel {

    @Inject
    private ResourceResolver resourceResolver;

    private List<String> childPageNames;

    @PostConstruct
    protected void init() {
        childPageNames = new ArrayList<>();
        String contentPath = "/content/wknd-fina";

        Resource contentResource = resourceResolver.getResource(contentPath);

        if (contentResource != null) {

            for (Resource child : contentResource.getChildren()) {
                String pagetitle = child.getValueMap().get("jcr:title", String.class);
                if (pagetitle != null)
                    childPageNames.add(pagetitle);
            }
        }

    }

    public List<String> getChildPageNames() {
        return childPageNames;

    }
}
