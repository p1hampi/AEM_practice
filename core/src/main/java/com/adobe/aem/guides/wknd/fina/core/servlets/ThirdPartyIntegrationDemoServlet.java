package com.adobe.aem.guides.wknd.fina.core.servlets;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(immediate = true, service = Servlet.class)
@SlingServletPaths({"/bin/fetchdetails"})
public class ThirdPartyIntegrationDemoServlet extends SlingAllMethodsServlet {
    static final String API_KEY = "c86d6c5ffbd04f7c931017fd5af53063";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet("https://newsapi.org/v2/everything?q=google&apiKey=" + API_KEY);
        HttpResponse httpResponse = httpClient.execute(getRequest);

        String jsonResponse = IOUtils.toString(httpResponse.getEntity().getContent());
        JSONObject jsonObject = new JSONObject(jsonResponse);

        JSONArray myjsonarray = jsonObject.getJSONArray("articles");
        for (int i = 0; i < myjsonarray.length(); i++) {
            JSONObject jsonObject1 = myjsonarray.getJSONObject(i);
            String author = (String) jsonObject1.get("author");
            String title = (String) jsonObject1.get("title");
        }


        //  Gson gson = new Gson();
//        String jsonResponse1 = gson.toJson(httpResponse).toString();
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }
}
