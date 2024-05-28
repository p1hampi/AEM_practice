package com.adobe.aem.guides.wknd.fina.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, immediate = true,
        property = "sling.servlet.methods=" + HttpConstants.METHOD_POST)
@SlingServletPaths({"/bin/fina/login"})

public class LoginServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean loginSuccessful = "admin".equals(username) && "admin".equals(password);
        if (loginSuccessful)
            response.sendRedirect("/content/wknd-fina/dashboard.html");
        else
            response.sendRedirect("/content/wknd-fina/demopage.html");


    }
}
