
package com.ProyectoWebYPatronesGrupo1.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity 
@Table(name = "perfil")
public class MiPerfil implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id
    private Long idUsuario;
    private String nombre;
    private String correo;

    public MiPerfil() {
    }

    public MiPerfil(Long idUsuario, String nombre, String correo) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.correo = correo;
    }  
}
