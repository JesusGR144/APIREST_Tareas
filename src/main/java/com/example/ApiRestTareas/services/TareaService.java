package com.example.ApiRestTareas.services;

import java.util.List;

import com.example.ApiRestTareas.entity.Tarea;

public interface TareaService {
    public List<Tarea> buscarTodo();

    public Tarea guardar(Tarea tarea);

    public Tarea buscarId(Long id);

    public void eliminar(Tarea tarea);
}
