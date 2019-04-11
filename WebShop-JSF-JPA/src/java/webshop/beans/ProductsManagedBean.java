package webshop.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import webshop.business.ProductBeanLocal;
import webshop.model.Proizvod;

@ManagedBean(name = "products", eager = true)
@SessionScoped
public class ProductsManagedBean implements Serializable {

    @EJB
    private ProductBeanLocal productBean;

    public List<Proizvod> getProducts() {

        return productBean.listAllProducts();
    }
}
