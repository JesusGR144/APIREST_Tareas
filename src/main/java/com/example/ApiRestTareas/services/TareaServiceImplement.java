package com.example.ApiRestTareas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiRestTareas.dao.TareaDao;
import com.example.ApiRestTareas.entity.Tarea;

import jakarta.transaction.Transactional;

@Service
public class TareaServiceImplement implements TareaService{

    @Autowired
    private TareaDao tareaDao;
    
    @Transactional
    @Override
    public List<Tarea> buscarTodo() {
        return (List<Tarea>) tareaDao.findAll();
    }

    @Transactional
    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaDao.save(tarea);        
    }

    @Transactional
    @Override
    public Tarea buscarId(Long id) {        
        return tareaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void eliminar(Tarea tarea) {
        tareaDao.delete(tarea);
    }
    
}
