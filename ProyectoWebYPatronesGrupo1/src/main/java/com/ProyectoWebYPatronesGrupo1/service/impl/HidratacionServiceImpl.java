
package com.ProyectoWebYPatronesGrupo1.service.impl;


import com.ProyectoWebYPatronesGrupo1.dao.HidratacionDao;
import com.ProyectoWebYPatronesGrupo1.domain.Hidratacion;
import com.ProyectoWebYPatronesGrupo1.service.HidratacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class HidratacionServiceImpl implements HidratacionService {

    @Autowired
    private HidratacionDao hidratacionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Hidratacion> getRegistrosHidratacion() {
        List<Hidratacion> hidratacion = hidratacionDao.findAll();

        return hidratacion;
    }

    @Override
    public Hidratacion getHidratacion(Hidratacion hidratacion) {
        return hidratacionDao.findById(hidratacion.getIdRegistro()).orElse(null);
    }

    @Override
    public void save(Hidratacion hidratacion) {
        hidratacionDao.save(hidratacion);
    }

    @Override
    public void delete(Hidratacion hidratacion) {
        hidratacionDao.delete(hidratacion);
    }

    
}
