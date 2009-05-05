package ftn.edu.ais.model;

import ftn.edu.ais.model.BaseObject;

//import java.util.HashSet;
//import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
//@Table(name="hraniteljska_porodica",catalog="evidencija_dece", uniqueConstraints = @UniqueConstraint(columnNames="jmbh") )
@Table(name="hraniteljska_porodica",catalog="evidencija_dece")
public class HraniteljskaPorodica extends BaseObject implements Serializable {
    private Long brlkh;
    private String jmbh;
    private String imeh;
    private String przh;
    private String adrh;
    private String gradh;
    private String ziph;
    private String telh;
    //private Set<Dete> detes = new HashSet<Dete>(0);

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getBrlkh() {
        return this.brlkh;
    }
    
    public void setBrlkh(Long brlkh) {
        this.brlkh = brlkh;
    }
    
    @Column(name="jmbh", unique=true, nullable=false)
    public String getJmbh() {
        return this.jmbh;
    }
    
    public void setJmbh(String jmbh) {
        this.jmbh = jmbh;
    }
    
    @Column(name="imeh", nullable=false, length=20)
    public String getImeh() {
        return this.imeh;
    }
    
    public void setImeh(String imeh) {
        this.imeh = imeh;
    }
    
    @Column(name="przh", nullable=false, length=20)
    public String getPrzh() {
        return this.przh;
    }
    
    public void setPrzh(String przh) {
        this.przh = przh;
    }
    
    @Column(name="adrh", nullable=false, length=50)
    public String getAdrh() {
        return this.adrh;
    }
    
    public void setAdrh(String adrh) {
        this.adrh = adrh;
    }
    
    @Column(name="gradh", nullable=false, length=20)
    public String getGradh() {
        return this.gradh;
    }
    
    public void setGradh(String gradh) {
        this.gradh = gradh;
    }
    
    @Column(name="ziph", nullable=false, length=10)
    public String getZiph() {
        return this.ziph;
    }
    
    public void setZiph(String ziph) {
        this.ziph = ziph;
    }
    
    @Column(name="telh", length=15)
    public String getTelh() {
        return this.telh;
    }
    
    public void setTelh(String telh) {
        this.telh = telh;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="hraniteljskaPorodica")
  //  public Set<Dete> getDetes() {
    //    return this.detes;
    //}
    
    //public void setDetes(Set<Dete> detes) {
      //  this.detes = detes;
    //}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HraniteljskaPorodica pojo = (HraniteljskaPorodica) o;

        if (jmbh != null ? !jmbh.equals(pojo.jmbh) : pojo.jmbh != null) return false;
        if (imeh != null ? !imeh.equals(pojo.imeh) : pojo.imeh != null) return false;
        if (przh != null ? !przh.equals(pojo.przh) : pojo.przh != null) return false;
        if (adrh != null ? !adrh.equals(pojo.adrh) : pojo.adrh != null) return false;
        if (gradh != null ? !gradh.equals(pojo.gradh) : pojo.gradh != null) return false;
        if (ziph != null ? !ziph.equals(pojo.ziph) : pojo.ziph != null) return false;
        if (telh != null ? !telh.equals(pojo.telh) : pojo.telh != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (jmbh != null ? jmbh.hashCode() : 0);
        result = 31 * result + (imeh != null ? imeh.hashCode() : 0);
        result = 31 * result + (przh != null ? przh.hashCode() : 0);
        result = 31 * result + (adrh != null ? adrh.hashCode() : 0);
        result = 31 * result + (gradh != null ? gradh.hashCode() : 0);
        result = 31 * result + (ziph != null ? ziph.hashCode() : 0);
        result = 31 * result + (telh != null ? telh.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("brlkh").append("='").append(getBrlkh()).append("', ");
        sb.append("jmbh").append("='").append(getJmbh()).append("', ");
        sb.append("imeh").append("='").append(getImeh()).append("', ");
        sb.append("przh").append("='").append(getPrzh()).append("', ");
        sb.append("adrh").append("='").append(getAdrh()).append("', ");
        sb.append("gradh").append("='").append(getGradh()).append("', ");
        sb.append("ziph").append("='").append(getZiph()).append("', ");
        sb.append("telh").append("='").append(getTelh()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
