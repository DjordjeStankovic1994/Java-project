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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "akcija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Akcija.findAll", query = "SELECT a FROM Akcija a")
    , @NamedQuery(name = "Akcija.findById", query = "SELECT a FROM Akcija a WHERE a.id = :id")
    , @NamedQuery(name = "Akcija.findByAkcija", query = "SELECT a FROM Akcija a WHERE a.akcija = :akcija")
    , @NamedQuery(name = "Akcija.findByProcenat", query = "SELECT a FROM Akcija a WHERE a.procenat = :procenat")})
public class Akcija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "akcija")
    private String akcija;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procenat")
    private int procenat;
    @OneToMany(mappedBy = "idAkcija")
    private List<DodatnaOprema> dodatnaOpremaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAkcija")
    private List<Proizvod> proizvodList;

    public Akcija() {
    }

    public Akcija(Integer id) {
        this.id = id;
    }

    public Akcija(Integer id, int procenat) {
        this.id = id;
        this.procenat = procenat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAkcija() {
        return akcija;
    }

    public void setAkcija(String akcija) {
        this.akcija = akcija;
    }

    public int getProcenat() {
        return procenat;
    }

    public void setProcenat(int procenat) {
        this.procenat = procenat;
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
        if (!(object instanceof Akcija)) {
            return false;
        }
        Akcija other = (Akcija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Akcija[ id=" + id + " ]";
    }
    
}
