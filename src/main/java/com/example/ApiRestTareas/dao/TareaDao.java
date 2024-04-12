package com.example.ApiRestTareas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiRestTareas.entity.Tarea;

@Repository
public interface TareaDao  extends JpaRepository<Tarea, Long>{
    
}
