package com.adobe.aem.guides.wknd.fina.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class)
public class ContactCardModel {

    @ValueMapValue
    @Via("resource")
    public List<Contact> contact;
    @SlingObject
    SlingHttpServletRequest slingHttpServletRequest;
}
