/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Marque;
import entites.MarqueFacade;
import entites.Produit;
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
public class ModificationProduit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private MarqueFacade marque;
    @EJB
    private ProduitFacade produit;
    
   
    protected void doGet
        (HttpServletRequest req , HttpServletResponse res)
        throws ServletException , IOException{
        res.setContentType("text/html;charset=UTF-8");
        try{
           PrintWriter out = res.getWriter();
           
            String nomref = req.getParameter("nomref");
           req.setAttribute("nomref", nomref);
           
           String nommarque = req.getParameter("nommarque");
           req.setAttribute("nommarque", nommarque);
           
            String denomination = req.getParameter("denomination");
           req.setAttribute("denomination", denomination);
           
            String prix = req.getParameter("prix");
           req.setAttribute("prix", prix);
           
            String poids = req.getParameter("poids");
           req.setAttribute("poids", poids);
           
            String volume = req.getParameter("volume");
           req.setAttribute("volume", volume);
           
           this.getServletContext().getRequestDispatcher("/modificationProduit.jsp").forward(req,res);
         
         
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
            
            String nomref = req.getParameter("nomref");
            String nommarque = req.getParameter("nommarque");
            String denomination = req.getParameter("denomination");
            double prix = Double.parseDouble(req.getParameter("prix"));
            double poids = Double.parseDouble(req.getParameter("poids"));
            double volume =  Double.parseDouble(req.getParameter("volume"));

                Marque  m = marque.findmarque(nommarque);
                
                Produit produit_modifie = new Produit(nomref , m , denomination , prix , poids , volume);
        
                boolean modifiee = produit.modifierProduit(produit_modifie);
                   if( modifiee ){
                       res.sendRedirect("ListingProduit");
                   }else{
                       out.print("<h3>pas modifie</h3>");
                       
                   }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
