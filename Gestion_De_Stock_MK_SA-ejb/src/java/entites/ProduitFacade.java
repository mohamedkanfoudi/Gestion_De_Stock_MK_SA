/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MK
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

    @PersistenceContext(unitName = "Gestion_De_Stock_MK_SA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }

    
    
    public boolean createProduit(Produit p ) {
    	Produit pp = em.find(Produit.class, p.getRefProduit());
    	if(pp == null) {
    		Marque m = em.find(Marque.class, p.getMarqueProduit().getNomMarque());
    		if(m!=null) {
    			em.persist(p);
    			return true;
    		}else {
    			return false; 
    		}
    	}
    	return false;
    
    }
    
    public boolean deleteProduit(String refP) {
    	Produit p = em.find(Produit.class, refP);
    	if(p!=null) {
    		em.remove(p);
        	return true;
    	}else {
    		return false;
    	}

    	
    }
    
    public boolean modifierProduit(Produit p) {
    	
    	Produit pp = em.find(Produit.class,p.getRefProduit() );
    	if(pp!=null) {
    		pp.setDénomination(p.getDénomination());
    		pp.setMarqueProduit(p.getMarqueProduit());
    		pp.setPrix(p.getPrix());
    		pp.setPoids(p.getPoids());
    		pp.setVolume(p.getVolume());
    		
    		em.persist(pp);
    		return true;
    	}
    	return false; 
    }
    public List<Produit> findAll(){
    	return  em.createQuery("SELECT object(o) from Produit as o").getResultList();
    }
    public List<Produit> listerProduitsMarque(String nomMarque){
    	return em.createQuery("SELECT object(o) from Produit as o WHERE o.marqueProduit.nomMarque = :marque")
    			.setParameter("marque" , nomMarque)
    			.getResultList();
    }
    
}
