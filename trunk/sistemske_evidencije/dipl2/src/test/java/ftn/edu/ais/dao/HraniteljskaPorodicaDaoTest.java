package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.HraniteljskaPorodica;
import org.springframework.dao.DataAccessException;

//import java.util.List;

public class HraniteljskaPorodicaDaoTest extends BaseDaoTestCase {
    private HraniteljskaPorodicaDao hraniteljskaPorodicaDao;

    public void setHraniteljskaPorodicaDao(HraniteljskaPorodicaDao hraniteljskaPorodicaDao) {
        this.hraniteljskaPorodicaDao = hraniteljskaPorodicaDao;
    }

    public void testAddAndRemoveHraniteljskaPorodica() throws Exception {
        HraniteljskaPorodica hraniteljskaPorodica = new HraniteljskaPorodica();

        // enter all required fields
        hraniteljskaPorodica.setAdrh("YmFbObFgCzFbHjHnJvClRbQiXtWpRbHdEcCeVlIoBfVbMpKyLm");
        hraniteljskaPorodica.setGradh("XcTfEfPrQmDqTvQwOdBq");
        hraniteljskaPorodica.setImeh("ErQoKmKqUzAlVrDnJcUe");
        hraniteljskaPorodica.setJmbh("ByBcVuCzBqWlZ");
        hraniteljskaPorodica.setPrzh("JvTvNyXkMqKdSyHbYcMw");
        hraniteljskaPorodica.setZiph("WaYfSrWdMt");

        log.debug("adding hraniteljskaPorodica...");
        hraniteljskaPorodica = hraniteljskaPorodicaDao.save(hraniteljskaPorodica);

        hraniteljskaPorodica = hraniteljskaPorodicaDao.get(hraniteljskaPorodica.getBrlkh());

        assertNotNull(hraniteljskaPorodica.getBrlkh());

        log.debug("removing hraniteljskaPorodica...");

        hraniteljskaPorodicaDao.remove(hraniteljskaPorodica.getBrlkh());

        try {
            hraniteljskaPorodicaDao.get(hraniteljskaPorodica.getBrlkh());
            fail("HraniteljskaPorodica found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}