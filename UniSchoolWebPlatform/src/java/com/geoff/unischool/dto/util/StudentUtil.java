/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto.util;

import com.geoff.unischool.data.News;
import com.geoff.unischool.dto.NewsDTO;
import com.geoff.unischool.dto.transfer.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CodeTRibe1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StudentUtil {
@PersistenceContext
EntityManager em;
    
    public ResponseDTO getStudentlistBySchoolID(Integer schoolID, DataUtil dataUtil){
        ResponseDTO resp = new ResponseDTO();
        try {
           
       } catch (Exception e) {
       }
        return resp;
    }
    public ResponseDTO getStudentlistByGrade(Integer gradeID, DataUtil dataUtil){
        ResponseDTO resp = new ResponseDTO();
        try {
           
       } catch (Exception e) {
       }
        return resp;
    }
   public ResponseDTO getNewsByGrade(Integer gradeID, DataUtil dataUtil){
        ResponseDTO resp = new ResponseDTO();
        try {
            
            Query q = em.createNamedQuery("News.findByGrade",News.class);
            q.setParameter("id", gradeID);
            List<News>list = q.getResultList();
            List<NewsDTO>dto = new ArrayList<>();
            for(News n:list){
                dto.add(new NewsDTO(n));
            }
            resp.setNewsList(dto);
            log.log(Level.INFO, "NewsList successful ");
       } catch (Exception e) {
           log.log(Level.OFF, "failed to get News List " + dataUtil.getErrorString(e));
       }
        return resp;
    }
   public ResponseDTO getNewsBySchool(Integer schoolID, DataUtil dataUtil){
        ResponseDTO resp = new ResponseDTO();
        try {
            
            Query q = em.createNamedQuery("News.findBySchool",News.class);
            q.setParameter("id", schoolID);
            List<News>list = q.getResultList();
            List<NewsDTO>dto = new ArrayList<>();
            for(News n:list){
                dto.add(new NewsDTO(n));
            }
            NewsDTO l = new NewsDTO();
            l.setTitle("Thabang the geek");
            l.setSubTitle("The streets");
            l.setSchoolID(schoolID);
            l.setDetails("sdfdsdfdsf");
            l.setLatitude(20.256);
            l.setLongitude(25.265);
            
            dto.add(l);
            
            resp.setNewsList(dto);
            log.log(Level.INFO, "NewsList successful ");
       } catch (Exception e) {
           log.log(Level.OFF, "failed to get News List " + dataUtil.getErrorString(e));
       }
        return resp;
    }
    private static final Logger log = Logger.getLogger(StudentUtil.class.getName());
   
}
