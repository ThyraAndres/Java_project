package com.Proyecto.Project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.Project.models.Equipo;
import com.Proyecto.Project.repository.EquipoRepository;

@Service
public class equipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo buscarPorId(Integer id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public List<Equipo> buscarEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo actualizarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void eliminarEquipo(int id) {
        Equipo equipo = buscarPorId(id);
        equipoRepository.delete(equipo);
    }
}
