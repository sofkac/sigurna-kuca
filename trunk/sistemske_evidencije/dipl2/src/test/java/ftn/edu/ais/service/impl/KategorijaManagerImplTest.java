package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.KategorijaDao;
import ftn.edu.ais.model.Kategorija;
import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class KategorijaManagerImplTest extends BaseManagerMockTestCase {
    private KategorijaManagerImpl manager = null;
    private KategorijaDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(KategorijaDao.class);
        manager = new KategorijaManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetKategorija() {
        log.debug("testing get...");

        final Long idk = 7L;
        final Kategorija kategorija = new Kategorija();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idk)));
            will(returnValue(kategorija));
        }});

        Kategorija result = manager.get(idk);
        assertSame(kategorija, result);
    }

    @Test
    public void testGetKategorijas() {
        log.debug("testing getAll...");

        final List kategorijas = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(kategorijas));
        }});

        List result = manager.getAll();
        assertSame(kategorijas, result);
    }

    @Test
    public void testSaveKategorija() {
        log.debug("testing save...");

        final Kategorija kategorija = new Kategorija();
        // enter all required fields
        kategorija.setNazk("UjHlCiImLgNgLrDkWjRxAoQoV");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(kategorija)));
        }});

        manager.save(kategorija);
    }

    @Test
    public void testRemoveKategorija() {
        log.debug("testing remove...");

        final Long idk = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idk)));
        }});

        manager.remove(idk);
    }
}