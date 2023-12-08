/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.CicloMenstrualDao;
import com.ProyectoWebYPatronesGrupo1.domain.CicloMenstrual;
import com.ProyectoWebYPatronesGrupo1.service.CicloMenstrualService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

    @Override
    public List<String> calcularTopTres(List<CicloMenstrual> ciclos) {
        Map<String, Integer> cuentas = new HashMap<>();
        cuentas.put("Dolor de cabeza", 0);
        cuentas.put("Cambios en la piel", 0);
        cuentas.put("Náuseas", 0);
        cuentas.put("Vómitos", 0);
        cuentas.put("Dolor Menstrual", 0);
        cuentas.put("Sangrado", 0);
        
        for (CicloMenstrual ciclo : ciclos) {
            if (ciclo.isDolorDeCabeza()) {
                cuentas.replace("Dolor de cabeza", cuentas.get("Dolor de cabeza")+1);
            }
            if (ciclo.isCambiosEnLaPiel()) {
                cuentas.replace("Cambios en la piel", cuentas.get("Cambios en la piel")+1);
            }
            if (ciclo.isNauseas()) {
                cuentas.replace("Náuseas", cuentas.get("Náuseas")+1);
            }
            if (ciclo.isVomitos()) {
                cuentas.replace("Vómitos", cuentas.get("Vómitos")+1);
            }
            if (ciclo.isDolorMenstrual()) {
                cuentas.replace("Dolor Menstrual", cuentas.get("Dolor Menstrual")+1);
            }
            if (ciclo.isSangrado()) {
                cuentas.replace("Sangrado", cuentas.get("Sangrado")+1);
            }
        }
       
        List<String> topSintomas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String maxSintoma = encontrarMaxSintoma(cuentas);
            if (maxSintoma != null) {
                topSintomas.add(maxSintoma);
                cuentas.remove(maxSintoma);
            }
        }

        return topSintomas;
    }

    private String encontrarMaxSintoma(Map<String, Integer> cuentas) {
        int maxContador = Integer.MIN_VALUE;
        String maxSintoma = null;

        for (Map.Entry<String, Integer> sintoma : cuentas.entrySet()) {
            if (sintoma.getValue() > maxContador) {
                maxContador = sintoma.getValue();
                maxSintoma = sintoma.getKey();
            }
        }

        return maxSintoma;
    }

    
}


