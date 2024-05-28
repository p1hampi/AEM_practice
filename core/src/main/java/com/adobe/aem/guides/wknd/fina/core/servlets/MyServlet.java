package com.adobe.aem.guides.wknd.fina.core.servlets;

import com.adobe.aem.guides.wknd.fina.core.models.MySlingModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(immediate = true, service = Servlet.class)
@SlingServletPaths({"/bin/page"})
public class MyServlet extends SlingAllMethodsServlet {

    private ModelFactory modelFactory;

    public MyServlet() {
    }

    public MyServlet(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        MySlingModel mySlingModel = modelFactory.createModel(request.getResource(), MySlingModel.class);

        if (mySlingModel != null)

            response.getWriter().write("Sling Model instantiated successfully!!!");
        else
            response.getWriter().write("Failed to instantiate Sling model, retry / refactor in code required!!");
    }
}
