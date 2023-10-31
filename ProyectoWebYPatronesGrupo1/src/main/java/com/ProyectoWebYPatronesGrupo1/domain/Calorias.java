/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity 
@Table(name = "calorias")
public class Calorias implements Serializable {
    
     private static final long serialVersionUID=1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;
    private int meta;
    private int calorias;

    public Calorias() {
    }

    public Calorias(int meta, int calorias) {
        this.meta = meta;
        this.calorias = calorias;
    }
    
    
    
}
