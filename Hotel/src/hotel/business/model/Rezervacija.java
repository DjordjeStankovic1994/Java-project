/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vboskovic
 */
@Entity
@Table(name = "rezervacija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")
    , @NamedQuery(name = "Rezervacija.findById", query = "SELECT r FROM Rezervacija r WHERE r.id = :id")
    , @NamedQuery(name = "Rezervacija.findByDatumDolaska", query = "SELECT r FROM Rezervacija r WHERE r.datumDolaska = :datumDolaska")
    , @NamedQuery(name = "Rezervacija.findByDatumOdlaska", query = "SELECT r FROM Rezervacija r WHERE r.datumOdlaska = :datumOdlaska")
    , @NamedQuery(name = "Rezervacija.findByCheckIn", query = "SELECT r FROM Rezervacija r WHERE r.checkIn = :checkIn")
    , @NamedQuery(name = "Rezervacija.findByCheckInDatum", query = "SELECT r FROM Rezervacija r WHERE r.checkInDatum = :checkInDatum")
    , @NamedQuery(name = "Rezervacija.findByCheckOut", query = "SELECT r FROM Rezervacija r WHERE r.checkOut = :checkOut")
    , @NamedQuery(name = "Rezervacija.findByCheckOutDatum", query = "SELECT r FROM Rezervacija r WHERE r.checkOutDatum = :checkOutDatum")
    , @NamedQuery(name = "Rezervacija.findByCena", query = "SELECT r FROM Rezervacija r WHERE r.cena = :cena")
    , @NamedQuery(name = "Rezervacija.findByStatus", query = "SELECT r FROM Rezervacija r WHERE r.status = :status")})
public class Rezervacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "datum_dolaska")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumDolaska;
    @Basic(optional = false)
    @Column(name = "datum_odlaska")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumOdlaska;
    @Basic(optional = false)
    @Column(name = "check_in")
    private boolean checkIn;
    @Column(name = "check_in_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDatum;
    @Basic(optional = false)
    @Column(name = "check_out")
    private boolean checkOut;
    @Column(name = "check_out_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDatum;
    @Basic(optional = false)
    @Column(name = "cena")
    private long cena;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @ManyToMany(mappedBy = "rezervacijaList")
    private List<Gost> gostList;
    @JoinColumn(name = "gost_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gost gostId;
    @JoinColumn(name = "soba_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Soba sobaId;

    public Rezervacija() {
    }

    public Rezervacija(Integer id) {
        this.id = id;
    }

    public Rezervacija(Integer id, Date datumDolaska, Date datumOdlaska, boolean checkIn, boolean checkOut, long cena, int status) {
        this.id = id;
        this.datumDolaska = datumDolaska;
        this.datumOdlaska = datumOdlaska;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cena = cena;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public Date getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(Date datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }

    public boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckInDatum() {
        return checkInDatum;
    }

    public void setCheckInDatum(Date checkInDatum) {
        this.checkInDatum = checkInDatum;
    }

    public boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCheckOutDatum() {
        return checkOutDatum;
    }

    public void setCheckOutDatum(Date checkOutDatum) {
        this.checkOutDatum = checkOutDatum;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<Gost> getGostList() {
        return gostList;
    }

    public void setGostList(List<Gost> gostList) {
        this.gostList = gostList;
    }

    public Gost getGostId() {
        return gostId;
    }

    public void setGostId(Gost gostId) {
        this.gostId = gostId;
    }

    public Soba getSobaId() {
        return sobaId;
    }

    public void setSobaId(Soba sobaId) {
        this.sobaId = sobaId;
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
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotel.business.model.Rezervacija[ id=" + id + " ]";
    }
    
}
