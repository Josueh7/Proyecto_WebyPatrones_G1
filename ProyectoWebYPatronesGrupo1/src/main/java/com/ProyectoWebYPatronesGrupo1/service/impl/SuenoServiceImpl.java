
package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.SuenoDao;
import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import com.ProyectoWebYPatronesGrupo1.service.SuenoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SuenoServiceImpl implements SuenoService {

    @Autowired
    private SuenoDao suenoDao;

    @Transactional(readOnly = true)
    
    @Override
    public List<Sueno> getRegistrosSueno() {
        List<Sueno> suenos = suenoDao.findAll();
        return suenos;
    }
    
    @Override
    public Sueno getSueno(Sueno sueno) {
         return suenoDao.findById(sueno.getIdRegistro()).orElse(null);
    }

    
    @Override
    public void save(Sueno sueno) {
        suenoDao.save(sueno);
    }

    
    @Override
    public void delete(Sueno sueno) {
        suenoDao.delete(sueno);
    }

    
}
