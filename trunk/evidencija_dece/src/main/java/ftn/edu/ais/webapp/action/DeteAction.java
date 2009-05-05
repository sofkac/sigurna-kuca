package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import ftn.edu.ais.service.DeteManager;
import ftn.edu.ais.service.HraniteljskaPorodicaManager;
import ftn.edu.ais.service.KategorijaManager;
import ftn.edu.ais.service.TimManager;
import ftn.edu.ais.model.Dete;
//import ftn.edu.ais.webapp.action.BaseAction;

import java.util.List;

public class DeteAction extends BaseAction implements Preparable {
    private DeteManager deteManager;
    private HraniteljskaPorodicaManager hraniteljskaPorodicaManager;
    private KategorijaManager kategorijaManager;
    private TimManager timManager;
    
    private List detes = null;
    private List hraniteljskaPorodicas = null;
    private List kategorijas = null;
    private List tims = null;
    
    private Dete dete;
    private Long  idde;

    public void setDeteManager(DeteManager deteManager) {
        this.deteManager = deteManager;
    }
    
    public void setHraniteljskaPorodicaManager(HraniteljskaPorodicaManager hraniteljskaPorodicaManager) {
        this.hraniteljskaPorodicaManager = hraniteljskaPorodicaManager;
    }
    
    public void setKategorijaManager(KategorijaManager kategorijaManager) {
        this.kategorijaManager = kategorijaManager;
    }
    
    public void setTimManager(TimManager timManager) {
        this.timManager = timManager;
    }

    public List getDetes() {
        return detes;
    }
    
    public List getHraniteljskaPorodicas() {
        return hraniteljskaPorodicas;
    }
    
    public List getKategorijas() {
        return kategorijas;
    }
    
    public List getTims() {
        return tims;
    }
        

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
    	
    	prepareLists();
    	
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String deteId = getRequest().getParameter("dete.idde");
            if (deteId != null && !deteId.equals("")) {
                dete = deteManager.get(new Long(deteId));
            }
        }
    }
    
    private void prepareLists() {
    	this.hraniteljskaPorodicas = hraniteljskaPorodicaManager.getAll();
    	this.kategorijas = kategorijaManager.getAll();
    	this.tims = timManager.getAll();
    }

    public String list() {
        detes = deteManager.getAll();
        return SUCCESS;
    }

    public void setIdde(Long  idde) {
        this. idde =  idde;
    }

    public Dete getDete() {
        return dete;
    }

    public void setDete(Dete dete) {
        this.dete = dete;
    }

    public String delete() {
        deteManager.remove(dete.getIdde());
        saveMessage(getText("dete.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idde != null) {
            dete = deteManager.get(idde);
        } else {
            dete = new Dete();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (dete.getIdde() == null);

        deteManager.save(dete);

        String key = (isNew) ? "dete.added" : "dete.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}