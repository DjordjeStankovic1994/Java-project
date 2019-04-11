package webshop.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import webshop.beans.model.ShoppingCartItem;
import webshop.business.PurchaseBeanLocal;

@ManagedBean(name = "purchaseMB", eager = true)
@ViewScoped
public class PurchaseManagedBean {

    @ManagedProperty(value = "#{loginMB}")
    private LoginManagedBean loginBean;

    @ManagedProperty(value = "#{korpa}")
    private KorpaManagedBean korpaBean;

    @EJB
    private PurchaseBeanLocal purchaseBean;
    
    private String creditCard;

    public String submitPurchase() {
    
        if (purchaseBean.addPurchase(loginBean.getLoggedInKorisnik(), korpaBean.getCartItems(), creditCard)) {
            korpaBean.emptyCart();
            return "success";
        }
        
        return "failure";
    }
    
    public String getProductList() {
        String result = "";
        List<ShoppingCartItem> items = korpaBean.getCartItems();
        for (ShoppingCartItem item : items) {
            result += (item.getProductNum()) + "x";
            result += (item.getProductName());
            result += ",\n\r";
        }
        return result;
    }
    
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public LoginManagedBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginManagedBean loginBean) {
        this.loginBean = loginBean;
    }

    public KorpaManagedBean getKorpaBean() {
        return korpaBean;
    }

    public void setKorpaBean(KorpaManagedBean korpaBean) {
        this.korpaBean = korpaBean;
    }

}
