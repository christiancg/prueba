package com.prueba.bci.service;

import com.prueba.bci.entity.Phone;
import com.prueba.bci.entity.Usuario;
import com.prueba.bci.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@Import(UsuarioServiceImpl.class)
@DataJpaTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void crearUsuario() {
        // ...

        Usuario usuario = new Usuario();
        usuario.setName("John Doe");
        usuario.setEmail("john@example.com");
        usuario.setPassword("a2asfGfdfdf4");
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setCityCode(11);
        phone.setNumber(3213213L);
        usuario.setPhones(phones);

        usuarioService.crearUsuario(usuario);

        Long id = usuario.getId();
        Assertions.assertNotNull(id);

        Usuario usuarioGuardado = usuarioRepository.findById(id).orElse(null);
        Assertions.assertNotNull(usuarioGuardado);
        Assertions.assertEquals("John Doe", usuarioGuardado.getName());
        Assertions.assertEquals("john@example.com", usuarioGuardado.getEmail());
        Assertions.assertEquals("a2asfGfdfdf4", usuarioGuardado.getPassword());
        Assertions.assertEquals(phones, usuarioGuardado.getPhones());
        Assertions.assertNotNull(usuarioGuardado.getCreated());
        Assertions.assertNotNull(usuarioGuardado.getLastLogin());
        // ...
    }

    @Test
    public void actualizarUsuario() {
        // ...
        Usuario usuario = new Usuario();
        usuario.setName("John Doe");
        usuario.setEmail("john@example.com");
        usuario.setPassword("a2asfGfdfdf4");
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setCityCode(11);
        phone.setNumber(3213213L);
        usuario.setPhones(phones);
        usuarioService.crearUsuario(usuario);
        Long id = usuario.getId();
        Assertions.assertNotNull(id);
        // ...
    }
}
