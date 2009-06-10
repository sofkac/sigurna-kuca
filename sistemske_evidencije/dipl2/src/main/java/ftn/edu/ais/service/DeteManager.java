package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Dete;

//import java.util.List;
import javax.jws.WebService;

@WebService
public interface DeteManager extends GenericManager<Dete, Long> {
    
}