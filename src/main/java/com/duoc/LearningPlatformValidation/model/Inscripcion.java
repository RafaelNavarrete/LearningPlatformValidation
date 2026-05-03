package com.duoc.LearningPlatformValidation.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase modelo que representa una inscripción de un estudiante en un curso
 * dentro de la plataforma de aprendizaje. Contiene el identificador del curso,
 * el identificador del estudiante y la fecha de inscripción.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cursoId;
    private Long estudianteId;

    
    private LocalDate fechaInscripcion;

    public Inscripcion() {}

    public Inscripcion(Long id, Long cursoId, Long estudianteId, LocalDate fechaInscripcion) {
        this.id = id;
        this.cursoId = cursoId;
        this.estudianteId = estudianteId;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getId() { return id; }
    public Long getCursoId() { return cursoId; }
    public Long getEstudianteId() { return estudianteId; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }

    public void setId(Long id) { this.id = id; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}