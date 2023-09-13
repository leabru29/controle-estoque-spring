package br.com.leandrobezerradasilva.backend.repositories.cadastro.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrobezerradasilva.backend.models.cadastro.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
