package com.adobe.aem.guides.wknd.fina.core.models;


import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.resource.Resource;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class)
@Exporter(name = "Jackson", extensions = "json")
public class ExporterDemo {

    @ValueMapValue
    String firstName;

    @ValueMapValue
    String lastName;

    @PostConstruct

    public static void init() {


    }


}
