
package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.CaloriasDao;
import com.ProyectoWebYPatronesGrupo1.domain.Calorias;
import com.ProyectoWebYPatronesGrupo1.service.CaloriasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class CaloriasServiceImpl implements CaloriasService {

    @Autowired
    private CaloriasDao caloriasDao;
    
    
    
    @Override
    public List<Calorias> getCalorias() {
        List<Calorias> calorias = caloriasDao.findAll();
         
         return calorias;
    }

    @Override
    public Calorias getCaloria(Calorias calorias) {
         return caloriasDao.findById(calorias.getIdRegistro()).orElse(null);
    }

    @Override
    public void save(Calorias calorias) {
        caloriasDao.save(calorias);
    }

    @Override
    public void delete(Calorias calorias) {
        caloriasDao.delete(calorias);
    }
    
}
