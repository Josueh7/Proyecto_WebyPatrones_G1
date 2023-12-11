
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
@Table(name = "peso")
public class Peso implements Serializable{
    
     private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeso;
    private double peso;
    private double altura;
    private double IMC;
    private String fecha;

    public Peso(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;

    }

    public Peso() {
    }

  
    
     
}
