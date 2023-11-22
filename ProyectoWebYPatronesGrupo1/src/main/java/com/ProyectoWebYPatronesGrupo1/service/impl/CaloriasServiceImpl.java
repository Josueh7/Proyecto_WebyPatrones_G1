package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.CaloriasDao;
import com.ProyectoWebYPatronesGrupo1.domain.Calorias;
import com.ProyectoWebYPatronesGrupo1.service.CaloriasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaloriasServiceImpl implements CaloriasService {

    @Autowired
    private CaloriasDao caloriasDao;

    @Transactional
    @Override
    public void save(Calorias calorias) {
        caloriasDao.save(calorias);
    }

    @Override
    public void delete(Calorias calorias) {
        caloriasDao.delete(calorias);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Calorias> getRegCalorias() {
        List<Calorias> calorias = caloriasDao.findAll();
        return calorias;
    }

    @Override
    public Calorias getRegCaloria(Calorias calorias) {
        return caloriasDao.findById(calorias.getIdCalorias()).orElse(null);
    }

}
