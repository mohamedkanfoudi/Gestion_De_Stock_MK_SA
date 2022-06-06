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
public class ListingProduit extends HttpServlet {

    @EJB
    private ProduitFacade produit;
    @EJB
    private MarqueFacade marque;
	
   protected void doGet
	(HttpServletRequest req , HttpServletResponse res ) 
	throws ServletException , IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = res.getWriter();
		//out.println("ici nous");
		this.getServletContext().getRequestDispatcher("/listeProduits.jsp").forward(req , res);
	}
}
