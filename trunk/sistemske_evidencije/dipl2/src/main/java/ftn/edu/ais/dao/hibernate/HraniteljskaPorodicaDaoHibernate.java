package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.HraniteljskaPorodica;
import ftn.edu.ais.dao.HraniteljskaPorodicaDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class HraniteljskaPorodicaDaoHibernate extends GenericDaoHibernate<HraniteljskaPorodica, Long> implements HraniteljskaPorodicaDao {

    public HraniteljskaPorodicaDaoHibernate() {
        super(HraniteljskaPorodica.class);
    }
}
