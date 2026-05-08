package com.duoc.LearningPlatformValidation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.services.CursoServices;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoServices cursoServices;

    @Autowired
    public CursoController(CursoServices cursoServices) {
        this.cursoServices = cursoServices;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodos() {
        return ResponseEntity.ok(cursoServices.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoServices.obtenerPorId(id);
        return curso.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> registrar(@RequestBody Curso curso) {
        Curso creado = cursoServices.registrar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> modificar(@PathVariable Long id, @RequestBody Curso curso) {
        if (cursoServices.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Curso actualizado = cursoServices.modificar(id, curso);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (cursoServices.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cursoServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

