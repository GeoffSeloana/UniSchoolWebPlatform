/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTRibe1
 */
@Entity
@Table(name = "news")
@NamedQueries({
    @NamedQuery(name = "News.findBySchool", query = "SELECT distinct a "
            + " FROM News a, Gradenews b "
            + " WHERE b.grade.school.schoolID = :id "
            + " AND a.newsID = b.news.newsID"),
    @NamedQuery(name = "News.findByGrade", query = "SELECT distinct a "
            + " FROM News a, Gradenews b "
            + " WHERE b.grade.gradeID = :id "
            + " AND a.newsID = b.news.newsID"),
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsID", query = "SELECT n FROM News n WHERE n.newsID = :newsID"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findBySubTitle", query = "SELECT n FROM News n WHERE n.subTitle = :subTitle"),
    @NamedQuery(name = "News.findByDetails", query = "SELECT n FROM News n WHERE n.details = :details"),
    @NamedQuery(name = "News.findByLongitude", query = "SELECT n FROM News n WHERE n.longitude = :longitude"),
    @NamedQuery(name = "News.findByLatitude", query = "SELECT n FROM News n WHERE n.latitude = :latitude")})
public class News implements Serializable {
    @Column(name = "datePubliched")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePubliched;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsID")
    private Integer newsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "subTitle")
    private String subTitle;
    @Size(max = 255)
    @Column(name = "details")
    private String details;
    @JoinColumn(name = "schoolID", referencedColumnName = "schoolID")
    @ManyToOne(optional = false)
    private School school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news")
    private List<Gradenews> gradenewsList;

    public News() {
    }

    public News(Integer newsID) {
        this.newsID = newsID;
    }

    public News(Integer newsID, String title) {
        this.newsID = newsID;
        this.title = title;
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
        hash += (newsID != null ? newsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsID == null && other.newsID != null) || (this.newsID != null && !this.newsID.equals(other.newsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.geoff.unischool.data.News[ newsID=" + newsID + " ]";
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

    public Date getDatePubliched() {
        return datePubliched;
    }

    public void setDatePubliched(Date datePubliched) {
        this.datePubliched = datePubliched;
    }
    
}
