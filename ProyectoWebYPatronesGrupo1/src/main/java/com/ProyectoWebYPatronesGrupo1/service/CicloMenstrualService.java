/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service;


import com.ProyectoWebYPatronesGrupo1.domain.CicloMenstrual;
import java.util.List;


public interface CicloMenstrualService {
    
    public List<CicloMenstrual> getRegistrosCicloMenstrual();
    
    public CicloMenstrual getCicloMenstrual(CicloMenstrual cicloMenstrual);

    public void save(CicloMenstrual cicloMenstrual);
    
    public void delete(CicloMenstrual cicloMenstrual);
    
    public List<String> calcularTopTres(List<CicloMenstrual> ciclos);
}
