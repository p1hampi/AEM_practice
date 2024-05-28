package com.adobe.aem.guides.wknd.fina.core.services;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Service Configuration", description = "Configuration for MyService")
public @interface MyServiceConfig {

    @AttributeDefinition(name = "Enabled", description = "Enable or disable MyService")
    boolean enabled() default true;

    @AttributeDefinition(name = "Timeout", description = "Timeout value for MyService")
    int timeout() default 3000;

}
