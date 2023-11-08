package com.ProyectoWebYPatronesGrupo1.service;

import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import java.util.List;

public interface SuenoService {

    public List<Sueno> getInfoRegSuenos();
    
    public Sueno getRegSueno(Sueno regSueno);

    public void save( Sueno regSueno);
    
    public void delete(Sueno regSueno);
}