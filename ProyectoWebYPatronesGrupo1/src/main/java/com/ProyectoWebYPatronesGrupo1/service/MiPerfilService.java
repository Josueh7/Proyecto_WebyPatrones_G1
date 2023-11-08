
package com.ProyectoWebYPatronesGrupo1.service;

import com.ProyectoWebYPatronesGrupo1.domain.MiPerfil;
import java.util.List;

public interface MiPerfilService {
    
    public MiPerfil getCampoPerfil(MiPerfil perfil);

    public void save( MiPerfil perfil);
    
    public void delete(MiPerfil perfil);
}

