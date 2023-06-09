package com.prueba.bci.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @NotEmpty(message = "El campo 'email' no puede estar vacío")
    @Email(message = "El campo 'email' debe ser una dirección de correo electrónico válida")
    private String email;
    @NotEmpty(message = "El campo 'password' no puede estar vacío")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d.*\\d)[a-zA-Z\\d]{8,12}$",
             message = "El campo 'password' debe tener una mayúscula, dos números y una longitud de 8 a 12 caracteres")
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private List<Phone> phones;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
}
