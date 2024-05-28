package com.adobe.aem.guides.wknd.fina.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolver;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class, property = {Constants.SERVICE_DESCRIPTION + "=Get Session servlet", ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/getSession", ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET})
public class GetSessionServlet extends SlingAllMethodsServlet {

    @Reference
    ResourceResolver resolver;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resolver = request.getResourceResolver();
        String nodePath = "/content/wknd-fina/in";
        Resource nodeResource = resolver.getResource(nodePath);

        if (nodeResource != null) {
            String title = nodeResource.getValueMap().get("jcr:title", String.class);

            response.setContentType("text/plain");


            response.getWriter().write("Title of the node: " + title);
        } else {
            response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);

            response.getWriter().write("Node Not Found at given path" + nodePath);

        }

    }

}

