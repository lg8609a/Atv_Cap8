// src/main/java/br/com/fiap/AtvCap8/repository/UsuarioRepository.java
package br.com.fiap.AtvCap8.repository;

import br.com.fiap.AtvCap8.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}