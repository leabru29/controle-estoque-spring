package br.com.leandrobezerradasilva.backend.repositories.operacoes;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrobezerradasilva.backend.models.operacoes.InventarioEstoque;

public interface InventarioEstoqueRepository extends JpaRepository<InventarioEstoque, Long> {

}
