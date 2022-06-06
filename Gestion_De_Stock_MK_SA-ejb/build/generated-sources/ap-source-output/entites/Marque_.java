package entites;

import entites.Produit;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-06T17:30:52")
@StaticMetamodel(Marque.class)
public class Marque_ { 

    public static volatile SingularAttribute<Marque, String> OrigineFabrication;
    public static volatile SingularAttribute<Marque, List> ListeRefMarque;
    public static volatile ListAttribute<Marque, Produit> ListeDesProduits;
    public static volatile SingularAttribute<Marque, String> NomMarque;

}