package br.com.leandrobezerradasilva.backend.repositories.cadastro;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrobezerradasilva.backend.models.cadastro.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

}
