package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Pripada;
import org.springframework.dao.DataAccessException;

//import java.util.List;

public class PripadaDaoTest extends BaseDaoTestCase {
    private PripadaDao pripadaDao;
    private ZanimanjeDao zanimanjeDao;
    private TimDao timDao;

    public void setPripadaDao(PripadaDao pripadaDao) {
        this.pripadaDao = pripadaDao;
    }
    
    public void setZanimanjeDao(ZanimanjeDao zanimanjeDao) {
        this.zanimanjeDao = zanimanjeDao;
    }
    
    public void setTimDao(TimDao timDao) {
        this.timDao = timDao;
    }


    public void testAddAndRemovePripada() throws Exception {
        Pripada pripada = new Pripada();
        pripada.setZanimanje(zanimanjeDao.get(-1L));
        pripada.setTim(timDao.get(-1L));

        // enter all required fields
        pripada.setBrlj("CqKxRbIvBkHcRkUkNbVpClDiGaYkEyGfDbRcPfAtWzSxZ");

        log.debug("adding pripada...");
        pripada = pripadaDao.save(pripada);

        pripada = pripadaDao.get(pripada.getIdp());

        assertNotNull(pripada.getIdp());

        log.debug("removing pripada...");

        pripadaDao.remove(pripada.getIdp());

        try {
            pripadaDao.get(pripada.getIdp());
            fail("Pripada found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}