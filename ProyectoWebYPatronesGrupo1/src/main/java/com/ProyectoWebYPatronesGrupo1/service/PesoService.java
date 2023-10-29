
package com.ProyectoWebYPatronesGrupo1.service;

import com.ProyectoWebYPatronesGrupo1.domain.Peso;
import java.util.List;

public interface PesoService {
    
     public List<Peso> getPesos();
    
    public Peso getPeso(Peso peso);

    public void save( Peso peso);
    
    public void delete(Peso peso);
}
