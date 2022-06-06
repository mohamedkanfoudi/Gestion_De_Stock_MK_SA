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
public class ListingProduit extends HttpServlet {

    @EJB
    private ProduitFacade produit;
    @EJB
    private MarqueFacade marque;
	
   protected void doGet
	(HttpServletRequest req , HttpServletResponse res ) 
	throws ServletException  , IOException{
		res.setContentType("text/html;charset=UTF-8");
	try{
                    
                PrintWriter out  = res.getWriter();
                
                
                
                List<Marque> marques = marque.findAll();
                List<Produit> produits = produit.findAll();
                
               
                req.setAttribute("marques", marques);
                req.setAttribute("produits" , produits);
               
                
                
                req.setAttribute("marquechoisi","choisir la marque");
		//out.println("ici nous");
		this.getServletContext().getRequestDispatcher("/listeProduits.jsp").forward(req , res);
	}catch(Exception e){
                    e.printStackTrace();
                }
        }
        
        protected void doPost
        (HttpServletRequest req , HttpServletResponse res)
                throws ServletException  ,IOException {
            try{
                PrintWriter out = res.getWriter();
                
                String nommarque = req.getParameter("marque");
                req.setAttribute("marquechoisi", nommarque);

                List<Marque> allmarques = marque.findAll();
                req.setAttribute("marques" , allmarques);
                
                List<Produit> allproduits;
                List<Produit> produitsmarque;
                if(nommarque.equals("all marques")){
                    allproduits = produit.findAll();
                    req.setAttribute("produits", allproduits);
                    
                }else{
                    produitsmarque = produit.listerProduitsMarque(nommarque);
                    req.setAttribute("produits" , produitsmarque);
                }
                
                
                
            }catch(Exception e){
                    e.printStackTrace();
                }
            
        }
}
