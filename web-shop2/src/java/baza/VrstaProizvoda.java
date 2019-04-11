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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "vrsta_proizvoda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VrstaProizvoda.findAll", query = "SELECT v FROM VrstaProizvoda v")
    , @NamedQuery(name = "VrstaProizvoda.findByIdVrstaproizvoda", query = "SELECT v FROM VrstaProizvoda v WHERE v.idVrstaproizvoda = :idVrstaproizvoda")
    , @NamedQuery(name = "VrstaProizvoda.findByNazivProizvoda", query = "SELECT v FROM VrstaProizvoda v WHERE v.nazivProizvoda = :nazivProizvoda")})
public class VrstaProizvoda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vrstaproizvoda")
    private Integer idVrstaproizvoda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv_proizvoda")
    private String nazivProizvoda;
    @JoinColumn(name = "id_kolona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kolona idKolona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNazivproizvoda")
    private List<Proizvod> proizvodList;

    public VrstaProizvoda() {
    }

    public VrstaProizvoda(Integer idVrstaproizvoda) {
        this.idVrstaproizvoda = idVrstaproizvoda;
    }

    public VrstaProizvoda(Integer idVrstaproizvoda, String nazivProizvoda) {
        this.idVrstaproizvoda = idVrstaproizvoda;
        this.nazivProizvoda = nazivProizvoda;
    }

    public Integer getIdVrstaproizvoda() {
        return idVrstaproizvoda;
    }

    public void setIdVrstaproizvoda(Integer idVrstaproizvoda) {
        this.idVrstaproizvoda = idVrstaproizvoda;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public Kolona getIdKolona() {
        return idKolona;
    }

    public void setIdKolona(Kolona idKolona) {
        this.idKolona = idKolona;
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
        hash += (idVrstaproizvoda != null ? idVrstaproizvoda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VrstaProizvoda)) {
            return false;
        }
        VrstaProizvoda other = (VrstaProizvoda) object;
        if ((this.idVrstaproizvoda == null && other.idVrstaproizvoda != null) || (this.idVrstaproizvoda != null && !this.idVrstaproizvoda.equals(other.idVrstaproizvoda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.VrstaProizvoda[ idVrstaproizvoda=" + idVrstaproizvoda + " ]";
    }
    
}
