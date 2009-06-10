package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Angazovan;
import org.springframework.dao.DataAccessException;

//import java.util.List;

public class AngazovanDaoTest extends BaseDaoTestCase {
    private AngazovanDao angazovanDao;
    private PripadaDao pripadaDao;
    private ZaposleniDao zaposleniDao;

    public void setAngazovanDao(AngazovanDao angazovanDao) {
        this.angazovanDao = angazovanDao;
    }
    
    public void setPripadaDao(PripadaDao pripadaDao) {
        this.pripadaDao = pripadaDao;
    }
    
    public void setZaposleniDao(ZaposleniDao zaposleniDao) {
        this.zaposleniDao = zaposleniDao;
    }

    public void testAddAndRemoveAngazovan() throws Exception {
        Angazovan angazovan = new Angazovan();
        angazovan.setPripada(pripadaDao.get(-1L));
        angazovan.setZaposleni(zaposleniDao.get(-1L));

        // enter all required fields
        angazovan.setData(new java.util.Date());

        log.debug("adding angazovan...");
        angazovan = angazovanDao.save(angazovan);

        angazovan = angazovanDao.get(angazovan.getIda());

        assertNotNull(angazovan.getIda());

        log.debug("removing angazovan...");

        angazovanDao.remove(angazovan.getIda());

        try {
            angazovanDao.get(angazovan.getIda());
            fail("Angazovan found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}