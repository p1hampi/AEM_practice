package com.adobe.aem.guides.wknd.fina.core.models;

import org.apache.sling.models.annotations.Model;
import org.osgi.resource.Resource;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class)
public class MySlingModel {

    @PostConstruct
    public void init() {

        System.out.println("I am from Model class");
    }
}
