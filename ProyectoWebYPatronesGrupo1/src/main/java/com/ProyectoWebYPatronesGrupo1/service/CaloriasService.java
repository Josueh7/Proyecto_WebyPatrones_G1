
package com.ProyectoWebYPatronesGrupo1.service;

import com.ProyectoWebYPatronesGrupo1.domain.Calorias;
import java.util.List;


public interface CaloriasService {
    
    public List<Calorias> getRegCalorias();
    
    public Calorias getRegCaloria(Calorias calorias);

    public void save( Calorias calorias);
    
    public void delete(Calorias calorias);
}
