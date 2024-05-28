package com.adobe.aem.guides.wknd.fina.core.servlets;


import com.adobe.aem.guides.wknd.fina.core.schedulers.SimpleScheduledTask;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.inject.Inject;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(immediate = true)
@SlingServletResourceTypes(resourceTypes = {"/myproj/abc/xyz"})
public class MyLogicServlet extends SlingAllMethodsServlet {
    @Reference
    SimpleScheduledTask myscheduler;
    @Inject
    private ResourceResolver resolver;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        myscheduler.run();

        response.getWriter().write("");


    }
}
