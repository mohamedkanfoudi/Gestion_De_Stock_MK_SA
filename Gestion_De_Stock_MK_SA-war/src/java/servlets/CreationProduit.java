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
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MK
 */
public class CreationProduit extends HttpServlet {


	@EJB
	private ProduitFacade produit;
	@EJB
	private MarqueFacade marque;
	
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
	(HttpServletRequest req , HttpServletResponse res ) 
	throws ServletException , IOException{
		try{
                        res.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = res.getWriter();
		//out.println("ici nous");
                
                List<Marque> Listmarque = marque.findAll();
                req.setAttribute( "ListMarque", Listmarque );
		this.getServletContext().getRequestDispatcher("/addProduit.jsp").forward(req , res);
                }catch(Exception e){
                    e.printStackTrace();
                }
                }
        
    protected void doPost
        (HttpServletRequest req , HttpServletResponse res)
        throws ServletException , IOException{
         
            try{
                
                res.setContentType("text/html;charset=UTF-8");
                PrintWriter out = res.getWriter();
                String nomref = req.getParameter("nomref");
                String denomination = req.getParameter("denomination");
                double prix = Double.parseDouble(req.getParameter("prix"));
                double poids = Double.parseDouble(req.getParameter("poids"));
                double volume = Double.parseDouble(req.getParameter("volume"));
                
                
                String marqueparameter = req.getParameter("marque");
                Marque  m = marque.findmarque(marqueparameter);
                
                Produit produit_cree = new Produit(nomref , m , denomination , prix , poids , volume);
        
                boolean cree = produit.createProduit(produit_cree);
                   if( cree ){
                       res.sendRedirect("ListingProduit");
                   }else{
                       res.sendRedirect("CreationProduit");
                       
                   }
                   
                   }catch(Exception e){
                    e.printStackTrace();
                }
        }
	

   
}
