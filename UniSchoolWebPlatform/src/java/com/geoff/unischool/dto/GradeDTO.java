/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto;

import com.geoff.unischool.data.Grade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GradeDTO {
    private Integer gradeID;
    private Integer gradeNumber;
    private List<StudentDTO> studentList = new ArrayList<>();
    private int schoolID;
    private List<GradenewsDTO> gradenewsList = new ArrayList<>();

    public GradeDTO() {
    }

    public GradeDTO(Grade g) {
        this.gradeID = g.getGradeID();
        this.gradeNumber = g.getGradeNumber();
        this.schoolID = g.getSchool().getSchoolID() ;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Integer getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(Integer gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public List<GradenewsDTO> getGradenewsList() {
        return gradenewsList;
    }

    public void setGradenewsList(List<GradenewsDTO> gradenewsList) {
        this.gradenewsList = gradenewsList;
    }

    
    
}
