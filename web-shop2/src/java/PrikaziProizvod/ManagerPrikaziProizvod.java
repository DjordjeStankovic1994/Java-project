
package PrikaziProizvod;

import baza.Proizvod;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "PrikaiProizvodMB" , eager = true)
@SessionScoped
public class ManagerPrikaziProizvod implements Serializable{
    @EJB
    private PrikaziProizvodBeanLocal prikaziBean;
    private Proizvod product;
    private Proizvod selectProduct;
    
    
    
    
    public List<Proizvod> getProducts() {

        return prikaziBean.listAllProducts();
    }

    public Proizvod getProduct() {
        return product;
    }

    public void setProduct(Proizvod product) {
        this.product = product;
    }

    public Proizvod getSelectProduct() {
        return selectProduct;
    }

    public void setSelectProduct(Proizvod selectProduct) {
        this.selectProduct = selectProduct;
    }
    
}
    

