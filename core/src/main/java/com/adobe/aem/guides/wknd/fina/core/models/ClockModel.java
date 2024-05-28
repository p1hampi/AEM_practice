package com.adobe.aem.guides.wknd.fina.core.models;

import java.text.SimpleDateFormat;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.joda.time.LocalTime;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;


@Model(adaptables = Resource.class)
public class ClockModel {
    private String currentTime;

    @PostConstruct
    protected void init() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        currentTime = formatter.format(date);
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
