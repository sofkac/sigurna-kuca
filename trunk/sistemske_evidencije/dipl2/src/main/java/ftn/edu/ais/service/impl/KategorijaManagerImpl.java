package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.KategorijaDao;
import ftn.edu.ais.model.Kategorija;
import ftn.edu.ais.service.KategorijaManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

//import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "KategorijaService", endpointInterface = "ftn.edu.ais.service.KategorijaManager")
public class KategorijaManagerImpl extends GenericManagerImpl<Kategorija, Long> implements KategorijaManager {
    KategorijaDao kategorijaDao;

    public KategorijaManagerImpl(KategorijaDao kategorijaDao) {
        super(kategorijaDao);
        this.kategorijaDao = kategorijaDao;
    }
}