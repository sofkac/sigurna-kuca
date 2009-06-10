package ftn.edu.ais.model;

import ftn.edu.ais.model.BaseObject;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.UniqueConstraint;

//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="dete",catalog="dipl2")
public class Dete extends BaseObject implements Serializable {
    private Long idde;
    private Tim tim;
    private Kategorija kategorija;
    private HraniteljskaPorodica hraniteljskaPorodica;
    private String jmbde;
    private String imede;
    private String przde;
    private Date drde;
    private String imer;
    private String przr;
    private String jmbr;
    private String adrr;
    private String gradr;
    private String zipr;
    private String telr;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdde() {
        return this.idde;
    }
    
    public void setIdde(Long idde) {
        this.idde = idde;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idt")
    public Tim getTim() {
        return this.tim;
    }
    
    public void setTim(Tim tim) {
        this.tim = tim;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idk", nullable=false)
    public Kategorija getKategorija() {
        return this.kategorija;
    }
    
    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="brlkh")
    public HraniteljskaPorodica getHraniteljskaPorodica() {
        return this.hraniteljskaPorodica;
    }
    
    public void setHraniteljskaPorodica(HraniteljskaPorodica hraniteljskaPorodica) {
        this.hraniteljskaPorodica = hraniteljskaPorodica;
    }
    
    @Column(name="jmbde", unique=true, nullable=false, length=13)
    public String getJmbde() {
        return this.jmbde;
    }
    
    public void setJmbde(String jmbde) {
        this.jmbde = jmbde;
    }
    
    @Column(name="imede", nullable=false, length=20)
    public String getImede() {
        return this.imede;
    }
    
    public void setImede(String imede) {
        this.imede = imede;
    }
    
    @Column(name="przde", nullable=false, length=20)
    public String getPrzde() {
        return this.przde;
    }
    
    public void setPrzde(String przde) {
        this.przde = przde;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="drde", nullable=false, length=0)
    public Date getDrde() {
        return this.drde;
    }
    
    public void setDrde(Date drde) {
        this.drde = drde;
    }
    
    @Column(name="imer", length=20)
    public String getImer() {
        return this.imer;
    }
    
    public void setImer(String imer) {
        this.imer = imer;
    }
    
    @Column(name="przr", length=20)
    public String getPrzr() {
        return this.przr;
    }
    
    public void setPrzr(String przr) {
        this.przr = przr;
    }
    
    @Column(name="jmbr", length=13)
    public String getJmbr() {
        return this.jmbr;
    }
    
    public void setJmbr(String jmbr) {
        this.jmbr = jmbr;
    }
    
    @Column(name="adrr", length=50)
    public String getAdrr() {
        return this.adrr;
    }
    
    public void setAdrr(String adrr) {
        this.adrr = adrr;
    }
    
    @Column(name="gradr", length=20)
    public String getGradr() {
        return this.gradr;
    }
    
    public void setGradr(String gradr) {
        this.gradr = gradr;
    }
    
    @Column(name="zipr", length=10)
    public String getZipr() {
        return this.zipr;
    }
    
    public void setZipr(String zipr) {
        this.zipr = zipr;
    }
    
    @Column(name="telr", length=15)
    public String getTelr() {
        return this.telr;
    }
    
    public void setTelr(String telr) {
        this.telr = telr;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dete pojo = (Dete) o;

        if (tim != null ? !tim.equals(pojo.tim) : pojo.tim != null) return false;
        if (kategorija != null ? !kategorija.equals(pojo.kategorija) : pojo.kategorija != null) return false;
        if (hraniteljskaPorodica != null ? !hraniteljskaPorodica.equals(pojo.hraniteljskaPorodica) : pojo.hraniteljskaPorodica != null) return false;
        if (jmbde != null ? !jmbde.equals(pojo.jmbde) : pojo.jmbde != null) return false;
        if (imede != null ? !imede.equals(pojo.imede) : pojo.imede != null) return false;
        if (przde != null ? !przde.equals(pojo.przde) : pojo.przde != null) return false;
        if (drde != null ? !drde.equals(pojo.drde) : pojo.drde != null) return false;
        if (imer != null ? !imer.equals(pojo.imer) : pojo.imer != null) return false;
        if (przr != null ? !przr.equals(pojo.przr) : pojo.przr != null) return false;
        if (jmbr != null ? !jmbr.equals(pojo.jmbr) : pojo.jmbr != null) return false;
        if (adrr != null ? !adrr.equals(pojo.adrr) : pojo.adrr != null) return false;
        if (gradr != null ? !gradr.equals(pojo.gradr) : pojo.gradr != null) return false;
        if (zipr != null ? !zipr.equals(pojo.zipr) : pojo.zipr != null) return false;
        if (telr != null ? !telr.equals(pojo.telr) : pojo.telr != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (tim != null ? tim.hashCode() : 0);
        result = 31 * result + (kategorija != null ? kategorija.hashCode() : 0);
        result = 31 * result + (hraniteljskaPorodica != null ? hraniteljskaPorodica.hashCode() : 0);
        result = 31 * result + (jmbde != null ? jmbde.hashCode() : 0);
        result = 31 * result + (imede != null ? imede.hashCode() : 0);
        result = 31 * result + (przde != null ? przde.hashCode() : 0);
        result = 31 * result + (drde != null ? drde.hashCode() : 0);
        result = 31 * result + (imer != null ? imer.hashCode() : 0);
        result = 31 * result + (przr != null ? przr.hashCode() : 0);
        result = 31 * result + (jmbr != null ? jmbr.hashCode() : 0);
        result = 31 * result + (adrr != null ? adrr.hashCode() : 0);
        result = 31 * result + (gradr != null ? gradr.hashCode() : 0);
        result = 31 * result + (zipr != null ? zipr.hashCode() : 0);
        result = 31 * result + (telr != null ? telr.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idde").append("='").append(getIdde()).append("', ");
        sb.append("tim").append("='").append(getTim()).append("', ");
        sb.append("kategorija").append("='").append(getKategorija()).append("', ");
        sb.append("hraniteljskaPorodica").append("='").append(getHraniteljskaPorodica()).append("', ");
        sb.append("jmbde").append("='").append(getJmbde()).append("', ");
        sb.append("imede").append("='").append(getImede()).append("', ");
        sb.append("przde").append("='").append(getPrzde()).append("', ");
        sb.append("drde").append("='").append(getDrde()).append("', ");
        sb.append("imer").append("='").append(getImer()).append("', ");
        sb.append("przr").append("='").append(getPrzr()).append("', ");
        sb.append("jmbr").append("='").append(getJmbr()).append("', ");
        sb.append("adrr").append("='").append(getAdrr()).append("', ");
        sb.append("gradr").append("='").append(getGradr()).append("', ");
        sb.append("zipr").append("='").append(getZipr()).append("', ");
        sb.append("telr").append("='").append(getTelr()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
