package webshop.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import webshop.beans.model.ShoppingCartItem;
import webshop.model.Proizvod;

@ManagedBean(name = "korpa", eager = true)
@SessionScoped
public class KorpaManagedBean implements Serializable {

    private List<ShoppingCartItem> cartItems = new ArrayList<>();

    private Integer productNum;

    public void addProduct(Proizvod proizvod) {
        for (ShoppingCartItem sci : cartItems) {
            if (sci.getProductName().equals(proizvod.getNaziv())) {
                sci.setProductNum(sci.getProductNum() + productNum);
                return;
            }
        }
        ShoppingCartItem newItem = new ShoppingCartItem();
        newItem.setProduct(proizvod);
        newItem.setProductNum(productNum);
        cartItems.add(newItem);
    }
    
    public int getTotalPrice() {
        int total = 0;
        for (ShoppingCartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }
    
    public void emptyCart() {
        cartItems = new ArrayList<>();
    }

    public List<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
    
}
