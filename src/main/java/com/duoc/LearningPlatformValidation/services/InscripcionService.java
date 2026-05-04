package com.duoc.LearningPlatformValidation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Inscripcion;
import com.duoc.LearningPlatformValidation.repository.InscripcionRepository;

/**
 * Clase de servicio que contiene la lógica de negocio relacionada con la inscripción.
 * Actúa como intermediario entre el repositorio y el controlador,
 * gestionando las operaciones CRUD de la entidad Inscripcion.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Service
public class InscripcionService {
    
    // Repositorio inyectado por constructor
    private final InscripcionRepository inscripcionRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    // Método Get - Consultar inscripciones por curso
    public List<Inscripcion> obtenerInscripcionesPorCurso(Long cursoId) {
        return inscripcionRepository.findByCursoId(cursoId);
    }

    // Método Post - Registrar una nueva inscripción
    public Inscripcion registrar(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    // Método Delete - Eliminar una inscripcion
    public void eliminar(Long id) {
        inscripcionRepository.deleteById(id);
    }   

}

