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
@Table(name = "sueno")
public class Sueno implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;
    private int horaInicio;
    private int horaFinal;

    public Sueno() {
    }

    public Sueno(int horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public Sueno(int horaInicio, int horaFinal) {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    } 
    
}
