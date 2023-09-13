package br.com.leandrobezerradasilva.backend.repositories.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leandrobezerradasilva.backend.models.cadastro.GrupoProduto;

public interface GrupoProdutoRepository extends JpaRepository<GrupoProduto, Long> {

}
