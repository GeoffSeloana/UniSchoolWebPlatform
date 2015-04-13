/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto;

import com.geoff.unischool.data.Student;
import java.io.Serializable;

public class StudentDTO  {
  private Integer studentID;
    private String firstName;
    private String middleName;
   private String lastName;
    private int schoolID;
    private int gradeID;
    private String email;

    public StudentDTO() {
    }

   

    public StudentDTO(Student s) {
        this.studentID = s.getStudentID();
        this.firstName = s.getFirstName();
        this.middleName = s.getMiddleName();
        this.lastName = s.getLastName();
        this.schoolID = s.getSchool().getSchoolID();
        this.gradeID = s.getGrade().getGradeID();
        this.email = s.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    
}
