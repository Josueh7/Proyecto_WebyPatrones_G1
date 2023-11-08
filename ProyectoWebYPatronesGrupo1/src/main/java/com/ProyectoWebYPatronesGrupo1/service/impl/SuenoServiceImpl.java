/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.SuenoDao;
import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import com.ProyectoWebYPatronesGrupo1.service.SuenoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danny
 */
public class SuenoServiceImpl implements SuenoService{

    @Autowired
    private SuenoDao suenoDao;


    @Override
    @Transactional
    public void save(Sueno regSueno) {
        suenoDao.save(regSueno);
    }

    @Override
    @Transactional
    public void delete(Sueno regSueno) {
        suenoDao.delete(regSueno);
    }


    @Override
    public List<Sueno> getInfoRegSuenos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Sueno getRegSueno(Sueno regSueno) {
        return suenoDao.findById(regSueno.getIdSueno()).orElse(null);
    }
    
}
