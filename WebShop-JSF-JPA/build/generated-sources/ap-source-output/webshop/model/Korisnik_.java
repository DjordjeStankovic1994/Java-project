package webshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webshop.model.Kupovina;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T16:03:00")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> ime;
    public static volatile SingularAttribute<Korisnik, String> prezime;
    public static volatile SingularAttribute<Korisnik, String> lozinka;
    public static volatile ListAttribute<Korisnik, Kupovina> kupovinaList;
    public static volatile SingularAttribute<Korisnik, Integer> id;
    public static volatile SingularAttribute<Korisnik, String> korisnickoIme;

}