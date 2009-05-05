package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.HraniteljskaPorodica;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface HraniteljskaPorodicaManager extends GenericManager<HraniteljskaPorodica, Long> {
    
}