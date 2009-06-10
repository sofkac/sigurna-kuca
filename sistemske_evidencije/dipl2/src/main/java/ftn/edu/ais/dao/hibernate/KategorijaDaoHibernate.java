package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Kategorija;
import ftn.edu.ais.dao.KategorijaDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class KategorijaDaoHibernate extends GenericDaoHibernate<Kategorija, Long> implements KategorijaDao {

    public KategorijaDaoHibernate() {
        super(Kategorija.class);
    }
}
