package com.adobe.aem.guides.wknd.fina.core.servlets;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(immediate = true, service = Servlet.class)
@SlingServletPaths(value = {"/bin/demoworkflow"})
public class WorkflowServlet extends SlingAllMethodsServlet {
    String status = "Workflow executing";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();

        String payLoad = request.getRequestParameter("page").toString();
        try {
            if (payLoad != null) {
                WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);

                WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/myworkflow_page_version");
                WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payLoad);
                status = workflowSession.startWorkflow(workflowModel, workflowData).getState();
            }
        } catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/json");
        response.getWriter().write(status);
    }

}

