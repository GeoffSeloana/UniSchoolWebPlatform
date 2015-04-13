/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto;

import com.geoff.unischool.data.Gradenews;
import java.io.Serializable;
import java.util.Date;

public class GradenewsDTO  {
    private Integer gradeNewsID;
    private Date datePublished;
    private int gradeID;
    private int newsID;

    public GradenewsDTO() {
    }

    public GradenewsDTO(Gradenews gn) {
        this.gradeNewsID = gn.getGradeNewsID();
        this.datePublished = gn.getDatePublished();
        this.gradeID = gn.getGrade().getGradeID();
        this.newsID = gn.getNews().getNewsID();
    }

    public Integer getGradeNewsID() {
        return gradeNewsID;
    }

    public void setGradeNewsID(Integer gradeNewsID) {
        this.gradeNewsID = gradeNewsID;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    
    
}
