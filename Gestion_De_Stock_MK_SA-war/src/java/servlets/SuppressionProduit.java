/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.MarqueFacade;
import entites.ProduitFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MK
 */
public class SuppressionProduit extends HttpServlet {

    @EJB
    private MarqueFacade marque;
    @EJB
    private ProduitFacade produit;
    
   
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
   
    protected void doGet
        (HttpServletRequest req , HttpServletResponse res)
        throws ServletException , IOException{
        res.setContentType("text/html;charset=UTF-8");
        try{
           PrintWriter out = res.getWriter();
           String nomref = req.getParameter("nomref");
           boolean delete = produit.deleteProduit(nomref);
           
           if(delete ){
               res.sendRedirect("ListingProduit");
           }else{
               out.print("<h3>pas suprrimé</h3>");
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void doPost
        (HttpServletRequest req , HttpServletResponse res)
        throws ServletException , IOException{
                res.setContentType("text/html;charset=UTF-8");
        try{
            PrintWriter out = res.getWriter();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
