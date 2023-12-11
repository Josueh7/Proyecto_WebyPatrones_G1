/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.service;


import com.ProyectoWebYPatronesGrupo1.domain.Suplementos;
import java.util.List;

public interface SuplementosService {
    
    public List<Suplementos> getRegistrosSuplementos();
    
    public Suplementos getSuplementos(Suplementos suplementos);

    public void save(Suplementos suplementos);
    
    public void delete(Suplementos suplementos);
    
      public List<String> calcularTopTres(List<Suplementos> suplementos);

}