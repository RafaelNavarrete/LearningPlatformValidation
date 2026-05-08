package com.duoc.LearningPlatformValidation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Evaluacion;
import com.duoc.LearningPlatformValidation.repository.EvaluacionRepository;

/**
 * Clase de servicio que contiene la lógica de negocio relacionada con las evaluaciones.
 * Actúa como intermediario entre el repositorio y el controlador,
 * gestionando las operaciones CRUD de la entidad Evaluacion.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Service
public class EvaluacionServices {

    // Repositorio inyectado por constructor
    private final EvaluacionRepository evaluacionRepository;
    
    @Autowired
    public EvaluacionServices(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    // Método Get - Consultar todas las evaluaciones
    public List<Evaluacion> obtenerTodas() {
        return evaluacionRepository.findAll();
    }

    // Método Get - Consultar evaluaciones por curso
    public List<Evaluacion> obtenerEvaluacionesPorCurso(Long cursoId) {
        return evaluacionRepository.findByCursoId(cursoId);
    }   

    // Método Post - Registrar una nueva evaluación
    public Evaluacion registrar(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    // Método Put - modificar una evaluación existente
    public Evaluacion modificar(Long id, Evaluacion evaluacion) {
        evaluacion.setId(id);
        return evaluacionRepository.save(evaluacion);
    }
     
}
