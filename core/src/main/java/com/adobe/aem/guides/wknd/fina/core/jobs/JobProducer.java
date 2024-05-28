//package com.adobe.aem.guides.wknd.fina.core.jobs;
//
//import org.apache.sling.event.jobs.Job;
//import org.apache.sling.event.jobs.JobBuilder;
//import org.apache.sling.event.jobs.JobManager;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component
//public class JobProducer {
//
//    @Reference
//    private JobManager jobManager;
//
//    public void submitJob(){
//        try {
//            Job job = JobBuilder.newBuilder().by("my-job-topic")
//                    .properties("key","value");
//            .build();
//            jobManager.addJob(job);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
