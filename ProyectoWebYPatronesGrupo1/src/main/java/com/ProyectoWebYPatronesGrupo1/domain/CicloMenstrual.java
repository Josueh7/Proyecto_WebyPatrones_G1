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
import java.time.LocalDateTime;
import lombok.Data;

@Data 
@Entity 
@Table(name = "ciclomenstrual")
public class CicloMenstrual implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;
    private LocalDateTime fecha;
    private String fechaStr;
    private boolean dolorDeCabeza;
    private boolean cambiosEnLaPiel;
    private boolean nauseas;
    private boolean vomitos;
    private boolean dolorMenstrual;
    private boolean sangrado;
    private boolean otrosSintomas;

    
    public CicloMenstrual() {
    }

    public CicloMenstrual(LocalDateTime fecha, String fechaStr, boolean dolorDeCabeza, boolean cambiosEnLaPiel, boolean nauseas, boolean vomitos, boolean dolorMenstrual, boolean sangrado, boolean otrosSintomas) {
        this.fecha = fecha;
        this.fechaStr = fechaStr;
        this.dolorDeCabeza = dolorDeCabeza;
        this.cambiosEnLaPiel = cambiosEnLaPiel;
        this.nauseas = nauseas;
        this.vomitos = vomitos;
        this.dolorMenstrual = dolorMenstrual;
        this.sangrado = sangrado;
        this.otrosSintomas = otrosSintomas;
    }
   

}
