
package com.ProyectoWebYPatronesGrupo1.service;

import com.ProyectoWebYPatronesGrupo1.domain.Hidratacion;
import java.util.List;

public interface HidratacionService {
    
    public List<Hidratacion> getRegistrosHidratacion();
    
    public Hidratacion getHidratacion(Hidratacion hidratacion);

    public void save( Hidratacion hidratacion);
    
    public void delete(Hidratacion hidratacion);

}
