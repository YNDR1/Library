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
@Table(name = "UYE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uye.findAll", query = "SELECT u FROM Uye u")
    , @NamedQuery(name = "Uye.findById", query = "SELECT u FROM Uye u WHERE u.id = :id")
    , @NamedQuery(name = "Uye.findByAdi", query = "SELECT u FROM Uye u WHERE u.adi = :adi")
    , @NamedQuery(name = "Uye.findBySoyisim", query = "SELECT u FROM Uye u WHERE u.soyisim = :soyisim")
    , @NamedQuery(name = "Uye.findByTelno", query = "SELECT u FROM Uye u WHERE u.telno = :telno")
    , @NamedQuery(name = "Uye.findByTcno", query = "SELECT u FROM Uye u WHERE u.tcno = :tcno")})
public class Uye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYISIM")
    private String soyisim;
    @Column(name = "TELNO")
    private String telno;
    @Column(name = "TCNO")
    private String tcno;

    public Uye() {
    }

    public Uye(Integer id, String adi, String soyisim, String telno, String tcno) {
        this.id = id;
        this.adi = adi;
        this.soyisim = soyisim;
        this.telno = telno;
        this.tcno = tcno;
    }
    

    public Uye(Integer id) {
        this.id = id;
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

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
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
        if (!(object instanceof Uye)) {
            return false;
        }
        Uye other = (Uye) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kutuphane2.Uye[ id=" + id + " ]";
    }
    
}
