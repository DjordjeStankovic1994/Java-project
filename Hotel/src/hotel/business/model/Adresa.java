/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.business.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vboskovic
 */
@Entity
@Table(name = "adresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a")
    , @NamedQuery(name = "Adresa.findById", query = "SELECT a FROM Adresa a WHERE a.id = :id")
    , @NamedQuery(name = "Adresa.findByUlica", query = "SELECT a FROM Adresa a WHERE a.ulica = :ulica")
    , @NamedQuery(name = "Adresa.findByBroj", query = "SELECT a FROM Adresa a WHERE a.broj = :broj")})
public class Adresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "broj")
    private String broj;
    @JoinColumn(name = "grad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grad gradId;
    @OneToMany(mappedBy = "adresaId")
    private List<Gost> gostList;

    public Adresa() {
    }

    public Adresa(Integer id) {
        this.id = id;
    }

    public Adresa(Integer id, String ulica, String broj) {
        this.id = id;
        this.ulica = ulica;
        this.broj = broj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Grad getGradId() {
        return gradId;
    }

    public void setGradId(Grad gradId) {
        this.gradId = gradId;
    }

    @XmlTransient
    public List<Gost> getGostList() {
        return gostList;
    }

    public void setGostList(List<Gost> gostList) {
        this.gostList = gostList;
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
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotel.business.model.Adresa[ id=" + id + " ]";
    }
    
}
