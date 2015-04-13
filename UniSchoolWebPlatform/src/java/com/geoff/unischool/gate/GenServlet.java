/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.gate;

import com.geoff.unischool.dto.transfer.RequestDTO;
import com.geoff.unischool.dto.transfer.ResponseDTO;
import com.geoff.unischool.util.DataUtil;
import com.geoff.unischool.util.Generate;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "GenServlet", urlPatterns = {"/GenServlet"})
public class GenServlet extends HttpServlet {

    @EJB
    DataUtil dataUtil;
    @EJB
    Generate generate;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        ResponseDTO resp = new ResponseDTO();
        RequestDTO req = new RequestDTO();
        try {
            req = getRequest(request);
            switch(req.getRequestType()){
                case RequestDTO.GENERATE_ALL:
                    resp = generate.generateAll(dataUtil);
                    break;
                default :
                    log.log(Level.OFF,"Error : RequestType Unknown");
            }
        } catch (Exception e) {
            log.log(Level.OFF,"Req Unknown");
            
        }finally{
            PrintWriter writer = response.getWriter();
            String feedback = gson.toJson(resp);
            writer.println(feedback);
        }
    }
    
    
    private RequestDTO getRequest(HttpServletRequest request){
        RequestDTO req = new RequestDTO();
        
        String json = request.getParameter("JSON");
        try {
            req = gson.fromJson(json, RequestDTO.class);
            log.log(Level.INFO,"JSON Okay");
        } catch (Exception e) {
            log.log(Level.OFF,"JSON NOT Okay");
            req.setRequestType(0);
        }
        
        return req;
    }
    Gson gson = new Gson();
    private static final Logger log = Logger.getLogger(GenServlet.class.getName());
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
