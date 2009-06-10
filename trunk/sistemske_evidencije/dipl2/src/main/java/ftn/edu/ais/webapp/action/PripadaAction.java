package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import ftn.edu.ais.service.PripadaManager;
import ftn.edu.ais.service.TimManager;
import ftn.edu.ais.service.ZanimanjeManager;
import ftn.edu.ais.model.Pripada;
import ftn.edu.ais.webapp.action.BaseAction;

import java.util.List;

public class PripadaAction extends BaseAction implements Preparable {
    private PripadaManager pripadaManager;
    private List pripadas = null;
    private TimManager timManager;
    private List tims = null;
    private ZanimanjeManager zanimanjeManager;
    private List zanimanjes = null;
    private Pripada pripada;
    private Long  idp;

    public void setPripadaManager(PripadaManager pripadaManager) {
        this.pripadaManager = pripadaManager;
    }

    public List getPripadas() {
        return pripadas;
    }
    
    public void setTimManager(TimManager timManager) {
        this.timManager = timManager;
    }

    public List getTims() {
        return tims;
    }
    
    public void setZanimanjeManager(ZanimanjeManager zanimanjeManager) {
        this.zanimanjeManager = zanimanjeManager;
    }

    public List getZanimanjes() {
        return zanimanjes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
    	prepareLists();
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String pripadaId = getRequest().getParameter("pripada.idp");
            if (pripadaId != null && !pripadaId.equals("")) {
                pripada = pripadaManager.get(new Long(pripadaId));
            }
        }
    }
    private void prepareLists() {
    	this.tims = timManager.getAll();
    	this.zanimanjes = zanimanjeManager.getAll();
    }

    public String list() {
        pripadas = pripadaManager.getAll();
        return SUCCESS;
    }

    public void setIdp(Long  idp) {
        this. idp =  idp;
    }

    public Pripada getPripada() {
        return pripada;
    }

    public void setPripada(Pripada pripada) {
        this.pripada = pripada;
    }

    public String delete() {
        pripadaManager.remove(pripada.getIdp());
        saveMessage(getText("pripada.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idp != null) {
            pripada = pripadaManager.get(idp);
        } else {
            pripada = new Pripada();
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

        boolean isNew = (pripada.getIdp() == null);

        pripadaManager.save(pripada);

        String key = (isNew) ? "pripada.added" : "pripada.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}