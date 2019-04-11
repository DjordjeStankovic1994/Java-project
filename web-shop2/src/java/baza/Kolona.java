/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "kolona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kolona.findAll", query = "SELECT k FROM Kolona k")
    , @NamedQuery(name = "Kolona.findById", query = "SELECT k FROM Kolona k WHERE k.id = :id")
    , @NamedQuery(name = "Kolona.findByNazivKolone", query = "SELECT k FROM Kolona k WHERE k.nazivKolone = :nazivKolone")})
public class Kolona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "naziv_kolone")
    private String nazivKolone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKolona")
    private List<VrstaProizvoda> vrstaProizvodaList;

    public Kolona() {
    }

    public Kolona(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivKolone() {
        return nazivKolone;
    }

    public void setNazivKolone(String nazivKolone) {
        this.nazivKolone = nazivKolone;
    }

    @XmlTransient
    public List<VrstaProizvoda> getVrstaProizvodaList() {
        return vrstaProizvodaList;
    }

    public void setVrstaProizvodaList(List<VrstaProizvoda> vrstaProizvodaList) {
        this.vrstaProizvodaList = vrstaProizvodaList;
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
        if (!(object instanceof Kolona)) {
            return false;
        }
        Kolona other = (Kolona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Kolona[ id=" + id + " ]";
    }
    
}
