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
@Table(name = "hidratacion")
public class Hidratacion implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHidratacion;
    private int cantVasosAgua;
    private String fecha; 

    public Hidratacion() {
    }

    public Hidratacion(int cantVasosAgua, String fecha) {
        this.cantVasosAgua = cantVasosAgua;
        this.fecha = fecha;
    }

   
    
}
