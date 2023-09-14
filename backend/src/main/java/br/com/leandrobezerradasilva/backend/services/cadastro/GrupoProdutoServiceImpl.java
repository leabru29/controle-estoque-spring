package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.GrupoProduto;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.GrupoProdutoRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.GrupoProdutoService;

@Service
public class GrupoProdutoServiceImpl implements GrupoProdutoService {

    @Autowired
    private GrupoProdutoRepository grupoProdutoRepository;

    @Override
    public GrupoProduto save(GrupoProduto grupoProduto) {
        return grupoProdutoRepository.save(grupoProduto);
    }

    @Override
    public List<GrupoProduto> findAll() {
        return grupoProdutoRepository.findAll();
    }

    @Override
    public GrupoProduto findById(Long id) {
        Optional<GrupoProduto> grupoProduOptional = grupoProdutoRepository.findById(id);
        return grupoProduOptional.get();
    }

    @Override
    public GrupoProduto update(GrupoProduto tipo) {
        GrupoProduto grupoProduto = findById(tipo.getId());
        grupoProduto.setGrupo(tipo.getGrupo());
        grupoProduto.setAtivo(tipo.getAtivo());
        GrupoProduto grupoProdutoAtualizado = grupoProdutoRepository.save(grupoProduto);
        return grupoProdutoAtualizado;
    }

    @Override
    public void deleteById(Long id) {
        GrupoProduto grupoProduto = findById(id);
        grupoProdutoRepository.deleteById(grupoProduto.getId());
    }

}
