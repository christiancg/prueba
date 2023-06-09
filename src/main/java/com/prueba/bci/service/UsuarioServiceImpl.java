package com.prueba.bci.service;

import com.prueba.bci.entity.Usuario;
import com.prueba.bci.exceptions.UsuarioValidationException;
import com.prueba.bci.repository.UsuarioRepository;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        LocalDateTime now = LocalDateTime.now();
        usuario.setCreated(now);
        usuario.setLastLogin(now);
        usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Long id, Usuario usuario) {
        LocalDateTime lastLogin = LocalDateTime.now();
        usuario.setId(id);
        usuario.setLastLogin(lastLogin);
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
