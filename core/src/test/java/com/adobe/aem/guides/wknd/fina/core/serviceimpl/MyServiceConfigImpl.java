package com.adobe.aem.guides.wknd.fina.core.serviceimpl;


import com.adobe.aem.guides.wknd.fina.core.services.MyServiceConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import java.lang.annotation.Annotation;

@Component(service = MyService.class, immediate = true)
@Designate(ocd = MyServiceConfig.class)
public class MyServiceConfigImpl implements MyServiceConfig {

    private boolean enabled;
    private int timeout;

    @Activate
    @Modified
    protected void activate(MyServiceConfig config) {
        this.enabled = config.enabled();
        this.timeout = config.timeout();
        // Additional activation logic
    }

    @Deactivate
    protected void deactivate() {
        // Deactivation logic
    }

    /*@Override
    public void doSomething() {
        if (enabled) {
            // Perform operation with timeout
        } else {
            // Log service is disabled
        }
    }
*/
    @Override
    public boolean enabled() {
        return false;
    }

    @Override
    public int timeout() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
