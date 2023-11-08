/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.dao;

import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author danny
 */
public interface SuenoDao extends JpaRepository<Sueno, Long>{
    
}
