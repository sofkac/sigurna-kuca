package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Dete;
import org.springframework.dao.DataAccessException;

//import java.util.List;

public class DeteDaoTest extends BaseDaoTestCase {
    private DeteDao deteDao;
    private TimDao timDao;
    private HraniteljskaPorodicaDao hraniteljskaPorodicaDao;
    private KategorijaDao kategorijaDao;

    public void setDeteDao(DeteDao deteDao) {
        this.deteDao = deteDao;
    }
    
    public void setTimDao(TimDao timDao) {
        this.timDao = timDao;
    }
    
    public void setHraniteljskaPorodicaDao(HraniteljskaPorodicaDao hraniteljskaPorodicaDao) {
        this.hraniteljskaPorodicaDao = hraniteljskaPorodicaDao;
    }

    public void setKategorijaDao(KategorijaDao kategorijaDao) {
        this.kategorijaDao = kategorijaDao;
    }

    
    public void testAddAndRemoveDete() throws Exception {
        Dete dete = new Dete();
        dete.setTim(timDao.get(-1L));
        dete.setHraniteljskaPorodica(hraniteljskaPorodicaDao.get(-1L));
        dete.setKategorija(kategorijaDao.get(-1L));
        
        // enter all required fields
        dete.setDrde(new java.util.Date());
        dete.setImede("QfQuXjWvVeKcBoWgNvRn");
        dete.setJmbde("SiHdSgBrBiDlK");
        dete.setPrzde("YnFmRjHlStMdQyMkSgYy");

        log.debug("adding dete...");
        dete = deteDao.save(dete);

        dete = deteDao.get(dete.getIdde());

        assertNotNull(dete.getIdde());

        log.debug("removing dete...");

        deteDao.remove(dete.getIdde());

        try {
            deteDao.get(dete.getIdde());
            fail("Dete found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}