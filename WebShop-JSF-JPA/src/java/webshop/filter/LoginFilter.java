package webshop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webshop.beans.LoginManagedBean;

/**
 *
 * @author Djorde Stankovic
 */
public class LoginFilter implements Filter {

    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // izvuci LoginBean iz sesije
        LoginManagedBean loginBean = (LoginManagedBean) ((HttpServletRequest) request).getSession().getAttribute("loginMB");
        String loginURL = ((HttpServletRequest)request).getContextPath() + "/faces/login.xhtml";
        String pageRequested = ((HttpServletRequest)request).getRequestURL().toString();
        
        if (loginBean == null || (loginBean.getLoggedInKorisnik() == null)) { // ako ne postoji bean u sesiji ili je izlogovan, redirektujemo korisnika na login stranu
            ((HttpServletResponse)response).sendRedirect(loginURL);
        }
        
        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }

    public void destroy() {
        // Nothing to do here!
    }

}
