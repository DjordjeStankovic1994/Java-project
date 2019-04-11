/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "specifikacija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specifikacija.findAll", query = "SELECT s FROM Specifikacija s")
    , @NamedQuery(name = "Specifikacija.findById", query = "SELECT s FROM Specifikacija s WHERE s.id = :id")
    , @NamedQuery(name = "Specifikacija.findByModel", query = "SELECT s FROM Specifikacija s WHERE s.model = :model")
    , @NamedQuery(name = "Specifikacija.findByTastatura", query = "SELECT s FROM Specifikacija s WHERE s.tastatura = :tastatura")
    , @NamedQuery(name = "Specifikacija.findByTauchScreen", query = "SELECT s FROM Specifikacija s WHERE s.tauchScreen = :tauchScreen")
    , @NamedQuery(name = "Specifikacija.findByProcesor", query = "SELECT s FROM Specifikacija s WHERE s.procesor = :procesor")
    , @NamedQuery(name = "Specifikacija.findByVelicina", query = "SELECT s FROM Specifikacija s WHERE s.velicina = :velicina")
    , @NamedQuery(name = "Specifikacija.findByKamera", query = "SELECT s FROM Specifikacija s WHERE s.kamera = :kamera")
    , @NamedQuery(name = "Specifikacija.findByMemorija", query = "SELECT s FROM Specifikacija s WHERE s.memorija = :memorija")
    , @NamedQuery(name = "Specifikacija.findBySoftver", query = "SELECT s FROM Specifikacija s WHERE s.softver = :softver")
    , @NamedQuery(name = "Specifikacija.findByKameraPrednja", query = "SELECT s FROM Specifikacija s WHERE s.kameraPrednja = :kameraPrednja")})
public class Specifikacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Size(max = 45)
    @Column(name = "tastatura")
    private String tastatura;
    @Size(max = 45)
    @Column(name = "tauch-screen")
    private String tauchScreen;
    @Size(max = 45)
    @Column(name = "procesor")
    private String procesor;
    @Size(max = 45)
    @Column(name = "velicina")
    private String velicina;
    @Size(max = 45)
    @Column(name = "kamera")
    private String kamera;
    @Size(max = 45)
    @Column(name = "memorija")
    private String memorija;
    @Size(max = 45)
    @Column(name = "softver")
    private String softver;
    @Size(max = 45)
    @Column(name = "kamera_prednja")
    private String kameraPrednja;
    @OneToMany(mappedBy = "idModel")
    private List<DodatnaOprema> dodatnaOpremaList;
    @OneToMany(mappedBy = "idModel")
    private List<Proizvod> proizvodList;

    public Specifikacija() {
    }

    public Specifikacija(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTastatura() {
        return tastatura;
    }

    public void setTastatura(String tastatura) {
        this.tastatura = tastatura;
    }

    public String getTauchScreen() {
        return tauchScreen;
    }

    public void setTauchScreen(String tauchScreen) {
        this.tauchScreen = tauchScreen;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public String getKamera() {
        return kamera;
    }

    public void setKamera(String kamera) {
        this.kamera = kamera;
    }

    public String getMemorija() {
        return memorija;
    }

    public void setMemorija(String memorija) {
        this.memorija = memorija;
    }

    public String getSoftver() {
        return softver;
    }

    public void setSoftver(String softver) {
        this.softver = softver;
    }

    public String getKameraPrednja() {
        return kameraPrednja;
    }

    public void setKameraPrednja(String kameraPrednja) {
        this.kameraPrednja = kameraPrednja;
    }

    @XmlTransient
    public List<DodatnaOprema> getDodatnaOpremaList() {
        return dodatnaOpremaList;
    }

    public void setDodatnaOpremaList(List<DodatnaOprema> dodatnaOpremaList) {
        this.dodatnaOpremaList = dodatnaOpremaList;
    }

    @XmlTransient
    public List<Proizvod> getProizvodList() {
        return proizvodList;
    }

    public void setProizvodList(List<Proizvod> proizvodList) {
        this.proizvodList = proizvodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specifikacija)) {
            return false;
        }
        Specifikacija other = (Specifikacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Specifikacija[ id=" + id + " ]";
    }
    
}
