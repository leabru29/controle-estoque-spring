package br.com.leandrobezerradasilva.backend.repositories.operacoes;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrobezerradasilva.backend.models.operacoes.EntradaProduto;

public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, Long> {

}
