package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Dete;
import ftn.edu.ais.dao.DeteDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class DeteDaoHibernate extends GenericDaoHibernate<Dete, Long> implements DeteDao {

    public DeteDaoHibernate() {
        super(Dete.class);
    }
}
