package com.duoc.LearningPlatformValidation.repository;

import com.duoc.LearningPlatformValidation.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Curso.
 * Proporciona automáticamente los métodos de acceso a datos
 * como guardar, buscar, listar y eliminar cursos.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}