/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto;

import com.geoff.unischool.data.News;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDTO  {
   private Integer newsID;
   private String title;
    private String subTitle;
   private String details;
    private Double longitude;
    private Double latitude;
    private int schoolID;
    private Date datePubliched;
    

    public NewsDTO() {
    }

    public NewsDTO(News n) {
        this.newsID = n.getNewsID();
        this.title = n.getTitle();
        this.subTitle = n.getSubTitle();
        this.details = n.getDetails();
        this.longitude = n.getLongitude();
        this.latitude = n.getLatitude();
        this.schoolID = n.getSchool().getSchoolID();
        this.datePubliched=n.getDatePubliched();
    }

    public Date getDatePubliched() {
        return datePubliched;
    }

    public void setDatePubliched(Date datePubliched) {
        this.datePubliched = datePubliched;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    

    
    
}
