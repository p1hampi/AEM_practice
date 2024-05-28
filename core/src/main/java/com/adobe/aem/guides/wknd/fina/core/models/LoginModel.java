package com.adobe.aem.guides.wknd.fina.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LoginModel {

    private String username;
    private String password;
    @ValueMapValue
    private String actionUrl;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getActionurl() {
        return actionUrl;
    }


}
