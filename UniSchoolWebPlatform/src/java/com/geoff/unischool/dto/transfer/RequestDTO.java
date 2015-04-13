/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto.transfer;

import com.geoff.unischool.dto.GradeDTO;
import com.geoff.unischool.dto.GradenewsDTO;
import com.geoff.unischool.dto.NewsDTO;
import com.geoff.unischool.dto.SchoolDTO;
import com.geoff.unischool.dto.StudentDTO;
import java.io.Serializable;

/**
 *
 * @author CodeTRibe1
 */
public class RequestDTO implements Serializable{
    public GradeDTO grade;
    public GradenewsDTO gradeNews;
    public NewsDTO news;
    public SchoolDTO school;
    public StudentDTO student;
    Integer gradeID,
            gradeNewsID,
            newsID,
            schoolID,
            studentID,
            requestType;
    
    public static final int GENERATE_ALL = 1;
    public static final int GET_NEWS_BY_SCHOOL = 2;
    public static final int GET_NEWS_BY_GRADE = 3;
    public Integer getGradeID() {
        return gradeID;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Integer getGradeNewsID() {
        return gradeNewsID;
    }

    public void setGradeNewsID(Integer gradeNewsID) {
        this.gradeNewsID = gradeNewsID;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public GradeDTO getGrade() {
        return grade;
    }

    public void setGrade(GradeDTO grade) {
        this.grade = grade;
    }

    public GradenewsDTO getGradeNews() {
        return gradeNews;
    }

    public void setGradeNews(GradenewsDTO gradeNews) {
        this.gradeNews = gradeNews;
    }

    public NewsDTO getNews() {
        return news;
    }

    public void setNews(NewsDTO news) {
        this.news = news;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
    
}
