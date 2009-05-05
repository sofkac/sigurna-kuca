package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import ftn.edu.ais.service.HraniteljskaPorodicaManager;
import ftn.edu.ais.model.HraniteljskaPorodica;
//import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class HraniteljskaPorodicaActionTest extends BaseActionTestCase {
    private HraniteljskaPorodicaAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new HraniteljskaPorodicaAction();
        HraniteljskaPorodicaManager hraniteljskaPorodicaManager = (HraniteljskaPorodicaManager) applicationContext.getBean("hraniteljskaPorodicaManager");
        action.setHraniteljskaPorodicaManager(hraniteljskaPorodicaManager);
    
        // add a test hraniteljskaPorodica to the database
        HraniteljskaPorodica hraniteljskaPorodica = new HraniteljskaPorodica();

        // enter all required fields
        hraniteljskaPorodica.setAdrh("SrCwCvMnEsDsDmZnJxBrVxIqMiQrYsBvUcPiIbPcIuJgHaJmTk");
        hraniteljskaPorodica.setGradh("LfYnKqPnFzViGkVoRqEv");
        hraniteljskaPorodica.setImeh("DzMwGnSfBhRgUxYbSmSk");
        String tmpJmbh = ("" + Math.random()).substring(0, 12);
        hraniteljskaPorodica.setJmbh(tmpJmbh);
        hraniteljskaPorodica.setPrzh("MhAqYcSpTdSqWwZaOmBf");
        hraniteljskaPorodica.setZiph("AdZgNxYjKu");

        hraniteljskaPorodicaManager.save(hraniteljskaPorodica);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getHraniteljskaPorodicas().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setBrlkh(-1L);
        assertNull(action.getHraniteljskaPorodica());
        assertEquals("success", action.edit());
        assertNotNull(action.getHraniteljskaPorodica());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setBrlkh(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getHraniteljskaPorodica());

        HraniteljskaPorodica hraniteljskaPorodica = action.getHraniteljskaPorodica();
        // update required fields
        hraniteljskaPorodica.setAdrh("NmWgMcEkRrPcNmSzOyVhJmOhIqZpRyPjRgCtHpAzXyRtDlHaHo");
        hraniteljskaPorodica.setGradh("CoCcJyHeKkFvIsUiNqHs");
        hraniteljskaPorodica.setImeh("McVaFkEjNdWcMqRfPwXp");
        hraniteljskaPorodica.setJmbh("8757114");
        hraniteljskaPorodica.setPrzh("UoGbPaSwKhTbVgOjXrCt");
        hraniteljskaPorodica.setZiph("LkJvJyHpRr");

        action.setHraniteljskaPorodica(hraniteljskaPorodica);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        HraniteljskaPorodica hraniteljskaPorodica = new HraniteljskaPorodica();
        hraniteljskaPorodica.setBrlkh(-2L);
        action.setHraniteljskaPorodica(hraniteljskaPorodica);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}