/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KÜRŞAD
 */
@Entity
@Table(name = "SILINENUYE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Silinenuye.findAll", query = "SELECT s FROM Silinenuye s")
    , @NamedQuery(name = "Silinenuye.findById", query = "SELECT s FROM Silinenuye s WHERE s.id = :id")
    , @NamedQuery(name = "Silinenuye.findByAdi", query = "SELECT s FROM Silinenuye s WHERE s.adi = :adi")
    , @NamedQuery(name = "Silinenuye.findBySoyadi", query = "SELECT s FROM Silinenuye s WHERE s.soyadi = :soyadi")
    , @NamedQuery(name = "Silinenuye.findByTcno", query = "SELECT s FROM Silinenuye s WHERE s.tcno = :tcno")
    , @NamedQuery(name = "Silinenuye.findByTelno", query = "SELECT s FROM Silinenuye s WHERE s.telno = :telno")
    , @NamedQuery(name = "Silinenuye.findByTarih", query = "SELECT s FROM Silinenuye s WHERE s.tarih = :tarih")})
public class Silinenuye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Id
    @Basic(optional = false)
    @Column(name = "TCNO")
    private String tcno;
    @Column(name = "TELNO")
    private String telno;
    @Column(name = "TARIH")
    private String tarih;

    public Silinenuye() {
    }

    public Silinenuye(Integer id, String adi, String soyadi, String tcno, String telno, String tarih) {
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.tcno = tcno;
        this.telno = telno;
        this.tarih = tarih;
    }

    public Silinenuye(Integer id) {
        this.id = id;
    }
    
    

    public Silinenuye(String tcno) {
        this.tcno = tcno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcno != null ? tcno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Silinenuye)) {
            return false;
        }
        Silinenuye other = (Silinenuye) object;
        if ((this.tcno == null && other.tcno != null) || (this.tcno != null && !this.tcno.equals(other.tcno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kutuphane2.Silinenuye[ tcno=" + tcno + " ]";
    }
    
}
