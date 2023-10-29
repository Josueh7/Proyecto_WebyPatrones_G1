package com.ProyectoWebYPatronesGrupo1.service.impl;

import com.ProyectoWebYPatronesGrupo1.dao.MiPerfilDao;
import com.ProyectoWebYPatronesGrupo1.domain.MiPerfil;
import com.ProyectoWebYPatronesGrupo1.service.MiPerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MiPerfilServiceImpl implements MiPerfilService {

    @Autowired
    private MiPerfilDao perfilDao;

    @Override
    @Transactional(readOnly = true)
    public List<MiPerfil> getInfoPerfil() {
         List<MiPerfil> informacion = perfilDao.findAll();
         
         return informacion;
    }

    @Override
    public MiPerfil getCampoPerfil(MiPerfil perfil) {
         return perfilDao.findById(perfil.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(MiPerfil perfil) {
        perfilDao.save(perfil);
    }

    @Override
    @Transactional
    public void delete(MiPerfil perfil) {
        perfilDao.delete(perfil);
    }

}
