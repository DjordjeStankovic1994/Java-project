
package dodajProizvod;


import baza.Proizvod;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;


@ManagedBean(name = "dodajMenager" , eager = true)
@SessionScoped
public class MangerDodajProizvod implements Serializable{
     UploadedFile file;
    
    
     Proizvod product = new Proizvod();
     private String boja;
    private int cena;
    private int kolicina;
  private String slika;
    private String message = "";
    
    @EJB
    private ProizvodBeanLocal dodajProizvodBean;
    
   

   
   
    
    public String dodajProizvod(){
       
       upload();
      boolean result = dodajProizvodBean.dodajProizvod(boja, kolicina, cena,slika);
       if(result){     
       FacesContext.getCurrentInstance().addMessage(null, new 
        FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Data Saved","") );
}else{
   FacesContext.getCurrentInstance().addMessage(null, new 
      FacesMessage(FacesMessage.SEVERITY_WARN, 
                "Data not Saved","") );
   
  }
   return null;
    }
    
    
    
    
    
 public void upload()  {
     if(file !=null){
     //  if(file.getSize()){
         try{
    FacesContext context = FacesContext.getCurrentInstance();
         ServletContext servletContext =(ServletContext)context.getExternalContext().getContext();
     String dbpath = servletContext.getRealPath("/");
     String webcut = dbpath.substring(0,dbpath.lastIndexOf("\\"));
     String buildcut = webcut.substring(0,webcut.lastIndexOf("\\"));
     String mainURLPath = buildcut.substring(0,buildcut.lastIndexOf("\\"));
     
             InputStream inputStream = file.getInputstream();
         
          
         String path = mainURLPath+"\\web\\resources\\images\\"+file.getFileName();
             File destFile = new File(path);
             if(!destFile.exists()){
                 FileUtils.copyInputStreamToFile(inputStream, destFile);
             
             }
             //toString();
        //     product.setProUrl(file.getFileName().toString());
         //  product.setSlika(file.getFileName().toString());
        slika =file.getFileName().toString();
    //moj pokusaj dodavanje slike (22:08)
         //    dodajProizvodBean.uploadImage().setSlika(file.getFileName().toString());
             
         }catch(Exception e){
             e.printStackTrace();
            return;
            
     }
  }
     } 
 public void brisiProizvod() throws IOException{
product = new Proizvod();
  FacesContext context = FacesContext.getCurrentInstance();
         ServletContext servletContext =(ServletContext)context.getExternalContext().getContext();
     String dbpath = servletContext.getRealPath("/");
     String webcut = dbpath.substring(0,dbpath.lastIndexOf("\\"));
     String buildcut = webcut.substring(0,webcut.lastIndexOf("\\"));
     String mainURLPath = buildcut.substring(0,buildcut.lastIndexOf("\\"));
     
             InputStream inputStream = file.getInputstream();
         
          
         String path = mainURLPath+"\\web\\resources\\images\\"+file.getFileName();
          File destFile = new File(path);
          if(destFile.exists()){
          destFile.delete();
          }
 }
    

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Proizvod getProduct() {
        return product;
    }

    public void setProduct(Proizvod product) {
        this.product = product;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
}
