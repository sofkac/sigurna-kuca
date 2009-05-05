package ftn.edu.ais.model;

import ftn.edu.ais.model.BaseObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
//@Table(name="dete",catalog="evidencija_dece", uniqueConstraints = @UniqueConstraint(columnNames="jmbde") )
@Table(name="dete",catalog="evidencija_dece")
public class Dete extends BaseObject implements Serializable {
    private Long idde;
    private Tim tim;
    private Kategorija kategorija;
    private HraniteljskaPorodica hraniteljskaPorodica;
    private String jmbde;
    private String imede;
    private String przde;

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
    
    @Column(name="jmbde", unique=true, nullable=false)
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
        sb.append("przde").append("='").append(getPrzde()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
