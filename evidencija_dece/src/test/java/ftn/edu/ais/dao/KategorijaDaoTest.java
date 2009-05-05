package ftn.edu.ais.dao;

//import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Kategorija;
import org.springframework.dao.DataAccessException;

//import java.util.List;

public class KategorijaDaoTest extends BaseDaoTestCase {
    private KategorijaDao kategorijaDao;

    public void setKategorijaDao(KategorijaDao kategorijaDao) {
        this.kategorijaDao = kategorijaDao;
    }

    public void testAddAndRemoveKategorija() throws Exception {
        Kategorija kategorija = new Kategorija();

        // enter all required fields
        kategorija.setNazk("HsTgVsYgYuAqLjCgGpEqXs");

        log.debug("adding kategorija...");
        kategorija = kategorijaDao.save(kategorija);

        kategorija = kategorijaDao.get(kategorija.getIdk());

        assertNotNull(kategorija.getIdk());

        log.debug("removing kategorija...");

        kategorijaDao.remove(kategorija.getIdk());

        try {
            kategorijaDao.get(kategorija.getIdk());
            fail("Kategorija found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}