package ftn.edu.ais.model;

import ftn.edu.ais.model.BaseObject;

//import java.util.HashSet;
//import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="pripada",catalog="dipl2")
public class Pripada extends BaseObject implements Serializable {
    private Long idp;
    private Tim tim;
    private Zanimanje zanimanje;
    private String brlj;
    //private Set<Angazovan> angazovans = new HashSet<Angazovan>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdp() {
        return this.idp;
    }
    
    public void setIdp(Long idp) {
        this.idp = idp;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idt", nullable=false)
    public Tim getTim() {
        return this.tim;
    }
    
    public void setTim(Tim tim) {
        this.tim = tim;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idzan", nullable=false)
    public Zanimanje getZanimanje() {
        return this.zanimanje;
    }
    
    public void setZanimanje(Zanimanje zanimanje) {
        this.zanimanje = zanimanje;
    }
    
    @Column(name="brlj", nullable=false, length=45)
    public String getBrlj() {
        return this.brlj;
    }
    
    public void setBrlj(String brlj) {
        this.brlj = brlj;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pripada")
//    public Set<Angazovan> getAngazovans() {
//        return this.angazovans;
//    }
//    
//    public void setAngazovans(Set<Angazovan> angazovans) {
//        this.angazovans = angazovans;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pripada pojo = (Pripada) o;

        if (tim != null ? !tim.equals(pojo.tim) : pojo.tim != null) return false;
        if (zanimanje != null ? !zanimanje.equals(pojo.zanimanje) : pojo.zanimanje != null) return false;
        if (brlj != null ? !brlj.equals(pojo.brlj) : pojo.brlj != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (tim != null ? tim.hashCode() : 0);
        result = 31 * result + (zanimanje != null ? zanimanje.hashCode() : 0);
        result = 31 * result + (brlj != null ? brlj.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idp").append("='").append(getIdp()).append("', ");
        sb.append("tim").append("='").append(getTim()).append("', ");
        sb.append("zanimanje").append("='").append(getZanimanje()).append("', ");
        sb.append("brlj").append("='").append(getBrlj()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
