package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import ftn.edu.ais.service.DeteManager;
import ftn.edu.ais.service.TimManager;
import ftn.edu.ais.service.HraniteljskaPorodicaManager;
import ftn.edu.ais.service.KategorijaManager;
import ftn.edu.ais.model.Dete;
import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class DeteActionTest extends BaseActionTestCase {
    private DeteAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new DeteAction();
        DeteManager deteManager = (DeteManager) applicationContext.getBean("deteManager");
        action.setDeteManager(deteManager);
        TimManager timManager = (TimManager) applicationContext.getBean("timManager");
        HraniteljskaPorodicaManager hraniteljskaPorodicaManager = (HraniteljskaPorodicaManager) applicationContext.getBean("hraniteljskaPorodicaManager");
        KategorijaManager kategorijaManager = (KategorijaManager) applicationContext.getBean("kategorijaManager");
    
        // add a test dete to the database
        Dete dete = new Dete();

        // enter all required fields
        dete.setDrde(new java.util.Date());
        dete.setImede("TnZxKuZmJyXaYlMcOqAq");
        String tpmJmbde = ("" + Math.random()).substring(0, 12);
        dete.setJmbde(tpmJmbde);
        dete.setPrzde("RnShKeSxPfNuJqXsEpYn");
        dete.setTim(timManager.get(-1L));
        dete.setHraniteljskaPorodica(hraniteljskaPorodicaManager.get(-1L));
        dete.setKategorija(kategorijaManager.get(-1L));

        deteManager.save(dete);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getDetes().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdde(-1L);
        assertNull(action.getDete());
        assertEquals("success", action.edit());
        assertNotNull(action.getDete());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdde(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getDete());

        Dete dete = action.getDete();
        // update required fields
        dete.setDrde(new java.util.Date());
        dete.setImede("PiPeZjCrBoNdOiPbVaIy");
        dete.setJmbde("NwTfJdSiGrKtA");
        dete.setPrzde("RxFaVjLuWhGkGpLjJyPa");

        action.setDete(dete);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Dete dete = new Dete();
        dete.setIdde(-2L);
        action.setDete(dete);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}