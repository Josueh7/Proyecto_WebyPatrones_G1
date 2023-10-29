
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
    private Long idRegistro;
    private int peso;
    private int altura;

    public Peso() {
    }

    public Peso(int peso, int altura) {
        this.peso = peso;
        this.altura = altura;
    }
    
    
     
}
