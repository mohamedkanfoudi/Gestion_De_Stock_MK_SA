/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author MK
 */
@Entity
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String NomMarque;
    
    private String OrigineFabrication;
    private List<String> ListeRefMarque ;
	
    @OneToMany
    public List<Produit> ListeDesProduits=new ArrayList<>(); 

    public String getNomMarque() {
        return NomMarque;
    }

    public void setNomMarque(String NomMarque) {
        this.NomMarque = NomMarque;
    }

    public String getOrigineFabrication() {
        return OrigineFabrication;
    }

    public void setOrigineFabrication(String OrigineFabrication) {
        this.OrigineFabrication = OrigineFabrication;
    }

    public List<String> getListeRefMarque() {
        return ListeRefMarque;
    }

    public void setListeRefMarque(List<String> ListeRefMarque) {
        this.ListeRefMarque = ListeRefMarque;
    }

    public List<Produit> getListeDesProduits() {
        return ListeDesProduits;
    }

    public void setListeDesProduits(List<Produit> ListeDesProduits) {
        this.ListeDesProduits = ListeDesProduits;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (NomMarque != null ? NomMarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.NomMarque == null 
                && other.NomMarque != null) 
                || (this.NomMarque != null 
                && !this.NomMarque.equals(other.NomMarque))) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        return "entites.Marque[ NomMarque=" + NomMarque + " ]";
    }
    
}
