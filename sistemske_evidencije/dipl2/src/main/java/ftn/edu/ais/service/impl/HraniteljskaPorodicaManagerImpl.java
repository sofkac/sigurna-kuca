package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.HraniteljskaPorodicaDao;
import ftn.edu.ais.model.HraniteljskaPorodica;
import ftn.edu.ais.service.HraniteljskaPorodicaManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

//import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "HraniteljskaPorodicaService", endpointInterface = "ftn.edu.ais.service.HraniteljskaPorodicaManager")
public class HraniteljskaPorodicaManagerImpl extends GenericManagerImpl<HraniteljskaPorodica, Long> implements HraniteljskaPorodicaManager {
    HraniteljskaPorodicaDao hraniteljskaPorodicaDao;

    public HraniteljskaPorodicaManagerImpl(HraniteljskaPorodicaDao hraniteljskaPorodicaDao) {
        super(hraniteljskaPorodicaDao);
        this.hraniteljskaPorodicaDao = hraniteljskaPorodicaDao;
    }
}