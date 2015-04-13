/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CodeTRibe1
 */
@Entity
@Table(name = "grade")
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findByGradeID", query = "SELECT g FROM Grade g WHERE g.gradeID = :gradeID"),
    @NamedQuery(name = "Grade.findByGradeNumber", query = "SELECT g FROM Grade g WHERE g.gradeNumber = :gradeNumber")})
public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gradeID")
    private Integer gradeID;
    @Column(name = "gradeNumber")
    private Integer gradeNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private List<Student> studentList;
    @JoinColumn(name = "schoolID", referencedColumnName = "schoolID")
    @ManyToOne(optional = false)
    private School school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private List<Gradenews> gradenewsList;

    public Grade() {
    }

    public Grade(Integer gradeID) {
        this.gradeID = gradeID;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    

    public List<Gradenews> getGradenewsList() {
        return gradenewsList;
    }

    public void setGradenewsList(List<Gradenews> gradenewsList) {
        this.gradenewsList = gradenewsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradeID != null ? gradeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.gradeID == null && other.gradeID != null) || (this.gradeID != null && !this.gradeID.equals(other.gradeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.geoff.unischool.data.Grade[ gradeID=" + gradeID + " ]";
    }
    
}
