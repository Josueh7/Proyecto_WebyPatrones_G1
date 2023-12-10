/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service.impl;


import com.ProyectoWebYPatronesGrupo1.dao.SuplementosDao;
import com.ProyectoWebYPatronesGrupo1.domain.Suplementos;
import com.ProyectoWebYPatronesGrupo1.service.SuplementosService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
    
    @Override
    public List<String> calcularTopTres(List<Suplementos> suplementos) {
        Map<String, Integer> cuentas = new HashMap<>();
        cuentas.put("proteina",0);
        cuentas.put("creatina", 0);
        cuentas.put("aminoacidos", 0);
        cuentas.put("multivitaminicos", 0);
        cuentas.put("preEntreno", 0);
        cuentas.put("otrosSuplementos", 0);
        
        for (Suplementos suplemento : suplementos) {
            if (suplemento.isProteina()) {
                cuentas.replace("proteina", cuentas.get("proteina")+1);
            }
            if (suplemento.isCreatina()) {
                cuentas.replace("creatina", cuentas.get("creatina")+1);
            }
            if (suplemento.isAminoacidos()) {
                cuentas.replace("aminoacidos", cuentas.get("aminoacidos")+1);
            }
            if (suplemento.isMultivitaminicos()) {
                cuentas.replace("multivitaminicos", cuentas.get("multivitaminicos")+1);
            }
            if (suplemento.isPreEntreno()) {
                cuentas.replace("preEntreno", cuentas.get("preEntreno")+1);
            }
            if (suplemento.isOtrosSuplementos()) {
                cuentas.replace("otrosSuplementos", cuentas.get("otrosSuplementos")+1);
            }
        }
       
        List<String> topSuplementos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String maxSuplemento = encontrarMaxSuplemento(cuentas);
            if (maxSuplemento != null) {
                topSuplementos.add(maxSuplemento);
                cuentas.remove(maxSuplemento);
            }
        }

        return topSuplementos;
    }

    private String encontrarMaxSuplemento(Map<String, Integer> cuentas) {
        int maxContador = Integer.MIN_VALUE;
        String maxSuplemento = null;

        for (Map.Entry<String, Integer> suplemento : cuentas.entrySet()) {
            if (suplemento.getValue() > maxContador) {
                maxContador = suplemento.getValue();
                maxSuplemento = suplemento.getKey();
            }
        }

        return maxSuplemento;
    }
}


