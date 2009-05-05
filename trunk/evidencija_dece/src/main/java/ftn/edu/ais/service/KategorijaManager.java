package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Kategorija;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface KategorijaManager extends GenericManager<Kategorija, Long> {
    
}