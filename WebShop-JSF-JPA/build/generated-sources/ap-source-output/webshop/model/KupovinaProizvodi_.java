package webshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webshop.model.Kupovina;
import webshop.model.Proizvod;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T16:03:00")
@StaticMetamodel(KupovinaProizvodi.class)
public class KupovinaProizvodi_ { 

    public static volatile SingularAttribute<KupovinaProizvodi, Proizvod> proizvodId;
    public static volatile SingularAttribute<KupovinaProizvodi, Integer> kolicina;
    public static volatile SingularAttribute<KupovinaProizvodi, Integer> id;
    public static volatile SingularAttribute<KupovinaProizvodi, Kupovina> kupovinaId;

}