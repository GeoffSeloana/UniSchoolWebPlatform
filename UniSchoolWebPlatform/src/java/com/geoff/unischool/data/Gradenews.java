/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CodeTRibe1
 */
@Entity
@Table(name = "gradenews")
@NamedQueries({
    @NamedQuery(name = "Gradenews.findAll", query = "SELECT g FROM Gradenews g"),
    @NamedQuery(name = "Gradenews.findByGradeNewsID", query = "SELECT g FROM Gradenews g WHERE g.gradeNewsID = :gradeNewsID"),
    @NamedQuery(name = "Gradenews.findByDatePublished", query = "SELECT g FROM Gradenews g WHERE g.datePublished = :datePublished")})
public class Gradenews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gradeNewsID")
    private Integer gradeNewsID;
    @Column(name = "datePublished")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePublished;
    @JoinColumn(name = "gradeID", referencedColumnName = "gradeID")
    @ManyToOne(optional = false)
    private Grade grade;
    @JoinColumn(name = "newsID", referencedColumnName = "newsID")
    @ManyToOne(optional = false)
    private News news;

    public Gradenews() {
    }

    public Gradenews(Integer gradeNewsID) {
        this.gradeNewsID = gradeNewsID;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradeNewsID != null ? gradeNewsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gradenews)) {
            return false;
        }
        Gradenews other = (Gradenews) object;
        if ((this.gradeNewsID == null && other.gradeNewsID != null) || (this.gradeNewsID != null && !this.gradeNewsID.equals(other.gradeNewsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.geoff.unischool.data.Gradenews[ gradeNewsID=" + gradeNewsID + " ]";
    }
    
}
