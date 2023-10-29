
package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.PesoDao;
import com.ProyectoWebYPatronesGrupo1.domain.Peso;
import com.ProyectoWebYPatronesGrupo1.service.PesoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PesoServiceImpl implements PesoService {

    
        @Autowired
    private PesoDao pesoDao;
    
    
    @Override
    public List<Peso> getPesos() {
        List<Peso> pesos = pesoDao.findAll();
         
         return pesos;
    }

    @Override
    public Peso getPeso(Peso peso) {
         return pesoDao.findById(peso.getIdRegistro()).orElse(null);
    }

    @Override
    public void save(Peso peso) {
        pesoDao.save(peso);
    }

    @Override
    public void delete(Peso peso) {
        pesoDao.delete(peso);
    }
    
}
