/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.CicloMenstrualDao;
import com.ProyectoWebYPatronesGrupo1.domain.CicloMenstrual;
import com.ProyectoWebYPatronesGrupo1.service.CicloMenstrualService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CicloMenstrualServiceImpl implements CicloMenstrualService {

    @Autowired
    private CicloMenstrualDao cicloMenstrualDao;

    @Transactional(readOnly = true)
    
    public List<CicloMenstrual> getRegistrosCicloMenstrual() {
        List<CicloMenstrual> ciclosMenstruales = cicloMenstrualDao.findAll();
        return ciclosMenstruales;
    }

    @Override
    public CicloMenstrual getCicloMenstrual(CicloMenstrual cicloMenstrual) {
        return cicloMenstrualDao.findById(cicloMenstrual.getIdRegistro()).orElse(null);
    }

    @Override
    public void save(CicloMenstrual cicloMenstrual) {
        cicloMenstrualDao.save(cicloMenstrual);
    }

    @Override
    public void delete(CicloMenstrual cicloMenstrual) {
        cicloMenstrualDao.delete(cicloMenstrual);
    }

    
}


