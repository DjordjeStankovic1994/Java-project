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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "komentar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komentar.findAll", query = "SELECT k FROM Komentar k")
    , @NamedQuery(name = "Komentar.findByIdkomentar", query = "SELECT k FROM Komentar k WHERE k.idkomentar = :idkomentar")})
public class Komentar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idkomentar")
    private Integer idkomentar;
    @Lob
    @Size(max = 65535)
    @Column(name = "text")
    private String text;
    @OneToMany(mappedBy = "idKomentar")
    private List<DodatnaOprema> dodatnaOpremaList;
    @OneToMany(mappedBy = "idKomentar")
    private List<Proizvod> proizvodList;

    public Komentar() {
    }

    public Komentar(Integer idkomentar) {
        this.idkomentar = idkomentar;
    }

    public Integer getIdkomentar() {
        return idkomentar;
    }

    public void setIdkomentar(Integer idkomentar) {
        this.idkomentar = idkomentar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        hash += (idkomentar != null ? idkomentar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komentar)) {
            return false;
        }
        Komentar other = (Komentar) object;
        if ((this.idkomentar == null && other.idkomentar != null) || (this.idkomentar != null && !this.idkomentar.equals(other.idkomentar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Komentar[ idkomentar=" + idkomentar + " ]";
    }
    
}
