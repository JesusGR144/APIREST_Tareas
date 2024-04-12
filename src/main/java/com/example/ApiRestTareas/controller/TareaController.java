package com.example.ApiRestTareas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiRestTareas.entity.Tarea;
import com.example.ApiRestTareas.services.TareaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Obtiene todas las tareas existentes
    @GetMapping(value = "/tareas")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Tarea> list = tareaService.buscarTodo();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtiene la tarea por medio del id ingresado
    @GetMapping(value = "/tareas/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Tarea data = tareaService.buscarId(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crea una nueva tarea
    @PostMapping(value = "/tareas")
    public ResponseEntity<Object> create(@RequestBody Tarea tarea) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Tarea res = tareaService.guardar(tarea);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualiza una tarea por medio del id ingresado
    @PutMapping("/tareas/{id}")
    public ResponseEntity<Object> update(@RequestBody Tarea tarea, @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            Tarea currentPerson = tareaService.buscarId(id);

            currentPerson.setDescripcion(tarea.getDescripcion());
            currentPerson.setEstado(tarea.getEstado());

            Tarea res = tareaService.guardar(tarea);

            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Elimina una tarea por medio del id ingresado
    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Tarea currentPerson = tareaService.buscarId(id);
            tareaService.eliminar(currentPerson);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
