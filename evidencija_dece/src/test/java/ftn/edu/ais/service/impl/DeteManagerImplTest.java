package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.DeteDao;
import ftn.edu.ais.model.Dete;
//import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class DeteManagerImplTest extends BaseManagerMockTestCase {
    private DeteManagerImpl manager = null;
    private DeteDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(DeteDao.class);
        manager = new DeteManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetDete() {
        log.debug("testing get...");

        final Long idde = 7L;
        final Dete dete = new Dete();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idde)));
            will(returnValue(dete));
        }});

        Dete result = manager.get(idde);
        assertSame(dete, result);
    }

    @Test
    public void testGetDetes() {
        log.debug("testing getAll...");

        final List detes = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(detes));
        }});

        List result = manager.getAll();
        assertSame(detes, result);
    }

    @Test
    public void testSaveDete() {
        log.debug("testing save...");

        final Dete dete = new Dete();
        // enter all required fields
        dete.setImede("AjHnZiHaMsUiDiSlNzYu");
        dete.setJmbde("4628242270");
        dete.setPrzde("SzQuQbPlArZlMeXcHpIs");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(dete)));
        }});

        manager.save(dete);
    }

    @Test
    public void testRemoveDete() {
        log.debug("testing remove...");

        final Long idde = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idde)));
        }});

        manager.remove(idde);
    }
}