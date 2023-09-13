package br.com.leandrobezerradasilva.backend.repositories.cadastro;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrobezerradasilva.backend.models.cadastro.LocalArmazenamento;

public interface LocalArmazenamentoRepository extends JpaRepository<LocalArmazenamento, UUID> {

}
