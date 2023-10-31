
package com.ProyectoWebYPatronesGrupo1.service;

import com.ProyectoWebYPatronesGrupo1.domain.Calorias;
import java.util.List;

public interface CaloriasService {
    
    public List<Calorias> getCalorias();
    
    public Calorias getCaloria(Calorias calorias);

    public void save( Calorias calorias);
    
    public void delete(Calorias calorias);
}
