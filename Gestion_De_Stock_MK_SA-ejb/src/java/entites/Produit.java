/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author MK
 */
@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String RefProduit;

    private String Dénomination;
    private double Prix;
    private double Poids;
    private double Volume;
    
    @ManyToOne
    public Marque MarqueProduit;

    public Produit(String refProduit,Marque marqueProduit, 
			String dénomination,
			double prix, double poids, double volume
			) {
		super();
		RefProduit = refProduit;
		MarqueProduit = marqueProduit;
		Dénomination = dénomination;
		Prix = prix;
		Poids = poids;
		Volume = volume;
	}


    public Produit() {   
    }

    public String getRefProduit() {
        return RefProduit;
    }

    public void setRefProduit(String RefProduit) {
        this.RefProduit = RefProduit;
    }

    public String getDénomination() {
        return Dénomination;
    }

    public void setDénomination(String Dénomination) {
        this.Dénomination = Dénomination;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double Prix) {
        this.Prix = Prix;
    }

    public double getPoids() {
        return Poids;
    }

    public void setPoids(double Poids) {
        this.Poids = Poids;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double Volume) {
        this.Volume = Volume;
    }

    public Marque getMarqueProduit() {
        return MarqueProduit;
    }

    public void setMarqueProduit(Marque MarqueProduit) {
        this.MarqueProduit = MarqueProduit;
    }
    



   

    @Override
    public String toString() {
        return "entites.Produit[ RefProduit=" + RefProduit + " ]";
    }
    
}
