
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
    private String contrasena;
    

    public MiPerfil() {
    }

    public MiPerfil(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

   
}
