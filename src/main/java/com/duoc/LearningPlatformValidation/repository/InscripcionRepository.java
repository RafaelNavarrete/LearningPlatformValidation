package com.duoc.LearningPlatformValidation.repository;

import com.duoc.LearningPlatformValidation.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA para la entidad Inscripcion.
 * Proporciona métodos de acceso a datos e incluye una consulta
 * personalizada para buscar inscripciones por ID de curso.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    // Busca todas las inscripciones asociadas a un curso específico
    List<Inscripcion> findByCursoId(Long cursoId);
}