package entites;

import entites.Marque;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-06T02:07:25")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Integer> RefProduit;
    public static volatile SingularAttribute<Produit, Double> Poids;
    public static volatile SingularAttribute<Produit, Double> Volume;
    public static volatile SingularAttribute<Produit, Double> Prix;
    public static volatile SingularAttribute<Produit, Marque> MarqueProduit;
    public static volatile SingularAttribute<Produit, String> Dénomination;

}