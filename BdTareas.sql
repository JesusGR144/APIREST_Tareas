CREATE DATABASE Tareas;

CREATE TYPE EstadoTarea AS ENUM ('pendiente', 'en progreso', 'completada');

CREATE TABLE Task (
    id SERIAL PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    estado EstadoTarea NOT NULL
);
