package com.duoc.LearningPlatformValidation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Usuario;
import com.duoc.LearningPlatformValidation.repository.UsuarioRepository;


/**
 * Clase de servicio que contiene la lógica de negocio relacionada con los usuarios.
 * Actúa como intermediario entre el repositorio y el controlador,
 * gestionando las operaciones CRUD de la entidad Usuario.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Service
public class UsuarioServices {

    // Repositorio inyectado por constructor
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método Get - devuelve todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Método Get - devuelve un usuario por su ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método Post - guardar un nuevo usuario
    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método Put - modificar un usuario existente
    public Usuario modificar(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    // Método Delete - elimina por ID
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
