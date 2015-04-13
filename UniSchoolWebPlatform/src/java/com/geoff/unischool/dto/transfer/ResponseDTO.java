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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTRibe1
 */
public class ResponseDTO implements Serializable{
    public GradeDTO grade;
    public GradenewsDTO gradeNews;
    public NewsDTO news;
    public SchoolDTO school;
    public StudentDTO student;
    
    List<GradeDTO> gradeList = new ArrayList<>();
    List<StudentDTO> studentList = new ArrayList<>();
    List<NewsDTO> newsList = new ArrayList<>();

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
