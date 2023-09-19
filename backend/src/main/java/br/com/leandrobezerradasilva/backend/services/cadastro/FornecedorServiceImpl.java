package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.Fornecedor;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.FornecedorRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.FornecedorService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;
import jakarta.transaction.Transactional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor) {

        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {

        return fornecedorRepository.findAll();

    }

    public Fornecedor findById(UUID id) {

        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.orElseThrow(() -> new EntidadeNaoEncontradaException("Fornecedor não encontrado."));
    }

    @Transactional
    public Fornecedor update(Fornecedor fornecedor) {

        Fornecedor fornecedorEncontrado = findById(fornecedor.getId());

        fornecedorEncontrado.setNome(fornecedor.getNome());
        fornecedorEncontrado.setRazao_social(fornecedor.getRazao_social());
        fornecedorEncontrado.setCnpj(fornecedor.getCnpj());
        fornecedorEncontrado.setTelefone(fornecedor.getTelefone());
        fornecedorEncontrado.setTelefone2(fornecedor.getTelefone2());
        fornecedorEncontrado.setCeluar(fornecedor.getCeluar());
        fornecedorEncontrado.setWhatsapp(fornecedor.getWhatsapp());
        fornecedorEncontrado.setEmail(fornecedor.getEmail());
        fornecedorEncontrado.setEmail2(fornecedor.getEmail2());
        fornecedorEncontrado.setCep(fornecedor.getCep());
        fornecedorEncontrado.setLogradouro(fornecedor.getLogradouro());
        fornecedorEncontrado.setNumero(fornecedor.getNumero());
        fornecedorEncontrado.setComplemento(fornecedor.getComplemento());
        fornecedorEncontrado.setBairro(fornecedor.getBairro());
        fornecedorEncontrado.setCidade(fornecedor.getCidade());
        fornecedorEncontrado.setEstado(fornecedor.getEstado());
        fornecedorEncontrado.setPais(fornecedor.getPais());

        Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedorEncontrado);

        return fornecedorAtualizado;
    }

    @Override
    public void deleteById(UUID id) {

        Fornecedor fornecedor = findById(id);

        fornecedorRepository.deleteById(fornecedor.getId());

    }

}
