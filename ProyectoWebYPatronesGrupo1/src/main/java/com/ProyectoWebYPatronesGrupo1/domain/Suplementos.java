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
@Table(name = "suplementos")
public class Suplementos implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;
    private boolean proteina;
    private boolean creatina;
    private boolean aminoacidos;
    private boolean multivitaminicos;
    private boolean preEntreno;
    private boolean otrosSuplementos;
    private String fecha;
    private int cantidad;

    public Suplementos() {
    }

    public Suplementos(boolean proteina, boolean creatina, boolean aminoacidos, boolean multivitaminicos, boolean preEntreno, boolean otrosSuplementos, int cantidad) {
        this.proteina = proteina;
        this.creatina = creatina;
        this.aminoacidos = aminoacidos;
        this.multivitaminicos = multivitaminicos;
        this.preEntreno = preEntreno;
        this.otrosSuplementos = otrosSuplementos;
        this.cantidad = cantidad;
    }


    
}
