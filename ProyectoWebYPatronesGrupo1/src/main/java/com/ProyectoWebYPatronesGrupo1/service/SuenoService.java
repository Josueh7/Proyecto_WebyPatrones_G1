
package com.ProyectoWebYPatronesGrupo1.service;


import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import java.util.List;

public interface SuenoService {
    
    public List<Sueno> getRegistrosSueno();
    
    public Sueno getSueno(Sueno sueno);

    public void save (Sueno sueno);
    
    public void delete(Sueno sueno);

  
}
