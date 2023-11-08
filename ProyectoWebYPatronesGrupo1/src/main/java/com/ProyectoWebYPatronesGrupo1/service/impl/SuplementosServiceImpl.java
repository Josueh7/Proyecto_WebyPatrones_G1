/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service.impl;


import com.ProyectoWebYPatronesGrupo1.dao.SuplementosDao;
import com.ProyectoWebYPatronesGrupo1.domain.Suplementos;
import com.ProyectoWebYPatronesGrupo1.service.SuplementosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SuplementosServiceImpl implements SuplementosService {

    @Autowired
    private SuplementosDao suplementosDao;


    @Transactional(readOnly = true)
    
    public List<Suplementos> getRegistrosSuplementos() {
        List<Suplementos> suplementos = suplementosDao.findAll();
        return suplementos;
    }

     @Override
    public Suplementos getSuplementos(Suplementos suplementos) {
        return suplementosDao.findById(suplementos.getIdRegistro()).orElse(null);
    }

    @Override
    public void save(Suplementos suplementos) {
        suplementosDao.save(suplementos);
    }

    @Override
    public void delete(Suplementos suplementos) {
        suplementosDao.delete(suplementos); 
    }
}


