package com.adobe.aem.guides.wknd.fina.core.serv;

import com.day.cq.search.QueryBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;

@Component
public class QueryDebuggerExample {

    @Reference
    QueryBuilder queryBuilder;
    @Reference
    Session mysession;

    //String predicate = queryBuilder.createQuery("query", mysession);


}
