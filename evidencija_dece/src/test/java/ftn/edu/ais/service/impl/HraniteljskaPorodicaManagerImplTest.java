package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.HraniteljskaPorodicaDao;
import ftn.edu.ais.model.HraniteljskaPorodica;
//import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class HraniteljskaPorodicaManagerImplTest extends BaseManagerMockTestCase {
    private HraniteljskaPorodicaManagerImpl manager = null;
    private HraniteljskaPorodicaDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(HraniteljskaPorodicaDao.class);
        manager = new HraniteljskaPorodicaManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetHraniteljskaPorodica() {
        log.debug("testing get...");

        final Long brlkh = 7L;
        final HraniteljskaPorodica hraniteljskaPorodica = new HraniteljskaPorodica();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(brlkh)));
            will(returnValue(hraniteljskaPorodica));
        }});

        HraniteljskaPorodica result = manager.get(brlkh);
        assertSame(hraniteljskaPorodica, result);
    }

    @Test
    public void testGetHraniteljskaPorodicas() {
        log.debug("testing getAll...");

        final List hraniteljskaPorodicas = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(hraniteljskaPorodicas));
        }});

        List result = manager.getAll();
        assertSame(hraniteljskaPorodicas, result);
    }

    @Test
    public void testSaveHraniteljskaPorodica() {
        log.debug("testing save...");

        final HraniteljskaPorodica hraniteljskaPorodica = new HraniteljskaPorodica();
        // enter all required fields
        hraniteljskaPorodica.setAdrh("IlIqRrYpNvHkElVsWaSwQkWfXvAaOuVoAaUoTzXpUgAlXkLyQz");
        hraniteljskaPorodica.setGradh("RsDbBpYbBvQpHqGpBwCq");
        hraniteljskaPorodica.setImeh("RuTeBdOvCwTyUvIfJhUu");
        hraniteljskaPorodica.setJmbh("7135667820");
        hraniteljskaPorodica.setPrzh("PnEpWfJoIpEjNkRdKdDu");
        hraniteljskaPorodica.setZiph("FrQxSmPjQu");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(hraniteljskaPorodica)));
        }});

        manager.save(hraniteljskaPorodica);
    }

    @Test
    public void testRemoveHraniteljskaPorodica() {
        log.debug("testing remove...");

        final Long brlkh = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(brlkh)));
        }});

        manager.remove(brlkh);
    }
}