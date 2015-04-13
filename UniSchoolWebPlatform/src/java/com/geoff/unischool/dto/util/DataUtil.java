/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.dto.util;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {
    @PersistenceContext
    EntityManager em;
    
    public String getErrorString(Exception e){
        StringBuilder errorDetails = new StringBuilder();
        
        if(e.getMessage() != null){
            errorDetails.append("\nGet Message :").append(e.getMessage()).append("\n\n");
        }
        if(e.toString() != null){
            errorDetails.append("\nTo String :").append(e.toString()).append("\n\n");
        }
        
        StackTraceElement[] s = e.getStackTrace();
        
        if(s.length > 0){
            StackTraceElement ss = s[0];
            String methodName = ss.getMethodName();
            String className = ss.getClassName();
            int lineNumber = ss.getLineNumber();
            
            errorDetails.append("Method Name: ").append(methodName).append("\n");
            errorDetails.append("Class Name: ").append(className).append("\n");
            errorDetails.append("Line Number: ").append(lineNumber).append("\n");
            
        }
        return errorDetails.toString();
    } 
    
}
