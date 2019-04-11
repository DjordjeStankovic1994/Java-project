package webshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webshop.model.KupovinaProizvodi;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T16:03:00")
@StaticMetamodel(Proizvod.class)
public class Proizvod_ { 

    public static volatile SingularAttribute<Proizvod, String> naziv;
    public static volatile SingularAttribute<Proizvod, Integer> id;
    public static volatile SingularAttribute<Proizvod, Integer> cena;
    public static volatile ListAttribute<Proizvod, KupovinaProizvodi> kupovinaProizvodiList;

}