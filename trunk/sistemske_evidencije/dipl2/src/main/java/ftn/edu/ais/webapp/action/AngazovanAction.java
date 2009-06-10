package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import ftn.edu.ais.service.AngazovanManager;
import ftn.edu.ais.service.PripadaManager;
import ftn.edu.ais.service.ZaposleniManager;
import ftn.edu.ais.model.Angazovan;
import ftn.edu.ais.webapp.action.BaseAction;

import java.util.List;

public class AngazovanAction extends BaseAction implements Preparable {
    private AngazovanManager angazovanManager;
    private List angazovans = null;
    private PripadaManager pripadaManager;
    private List pripadas = null;
    private ZaposleniManager zaposleniManager;
    private List zaposlenies = null;
    private Angazovan angazovan;
    private Long  ida;

    public void setAngazovanManager(AngazovanManager angazovanManager) {
        this.angazovanManager = angazovanManager;
    }

    public List getAngazovans() {
        return angazovans;
    }
    
    public void setPripadaManager(PripadaManager pripadaManager) {
        this.pripadaManager = pripadaManager;
    }

    public List getPripadas() {
        return pripadas;
    }
    
    public void setZaposleniManager(ZaposleniManager zaposleniManager) {
        this.zaposleniManager = zaposleniManager;
    }

    public List getZaposlenies() {
        return zaposlenies;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
      	prepareLists();
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String angazovanId = getRequest().getParameter("angazovan.ida");
            if (angazovanId != null && !angazovanId.equals("")) {
                angazovan = angazovanManager.get(new Long(angazovanId));
            }
        }
    }
    private void prepareLists() {
    	this.pripadas = pripadaManager.getAll();
    	this.zaposlenies = zaposleniManager.getAll();
    }


    public String list() {
        angazovans = angazovanManager.getAll();
        return SUCCESS;
    }

    public void setIda(Long  ida) {
        this. ida =  ida;
    }

    public Angazovan getAngazovan() {
        return angazovan;
    }

    public void setAngazovan(Angazovan angazovan) {
        this.angazovan = angazovan;
    }

    public String delete() {
        angazovanManager.remove(angazovan.getIda());
        saveMessage(getText("angazovan.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (ida != null) {
            angazovan = angazovanManager.get(ida);
        } else {
            angazovan = new Angazovan();
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

        boolean isNew = (angazovan.getIda() == null);

        angazovanManager.save(angazovan);

        String key = (isNew) ? "angazovan.added" : "angazovan.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}