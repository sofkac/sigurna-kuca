package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import ftn.edu.ais.service.KategorijaManager;
import ftn.edu.ais.model.Kategorija;
import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class KategorijaActionTest extends BaseActionTestCase {
    private KategorijaAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new KategorijaAction();
        KategorijaManager kategorijaManager = (KategorijaManager) applicationContext.getBean("kategorijaManager");
        action.setKategorijaManager(kategorijaManager);
    
        // add a test kategorija to the database
        Kategorija kategorija = new Kategorija();

        // enter all required fields
        kategorija.setNazk("VuHrEhIpCcNcRzAxVpBaLmGjP");

        kategorijaManager.save(kategorija);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getKategorijas().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdk(-1L);
        assertNull(action.getKategorija());
        assertEquals("success", action.edit());
        assertNotNull(action.getKategorija());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdk(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getKategorija());

        Kategorija kategorija = action.getKategorija();
        // update required fields
        kategorija.setNazk("NlUdDoOaGiXcFoWfYqUiCwUqJ");

        action.setKategorija(kategorija);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Kategorija kategorija = new Kategorija();
        kategorija.setIdk(-2L);
        action.setKategorija(kategorija);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}