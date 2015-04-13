/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto;

import com.geoff.unischool.data.School;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolDTO  {
    private Integer schoolID;
    private String name;
    private String slogan;
   private double longitude;
    private double latitude;
    private List<NewsDTO> newsList = new ArrayList<>();
   private List<StudentDTO> studentList = new ArrayList<>();
    private List<GradeDTO> gradeList = new ArrayList<>();

    public SchoolDTO() {
    }

    public SchoolDTO(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public SchoolDTO(School s) {
        this.schoolID = s.getSchoolID();
        this.name = s.getName();
        this.slogan = s.getSlogan();
        this.longitude = s.getLongitude();
        this.latitude = s.getLatitude();
    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<NewsDTO> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsDTO> newsList) {
        this.newsList = newsList;
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    public List<GradeDTO> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<GradeDTO> gradeList) {
        this.gradeList = gradeList;
    }
    
}
