package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.Fornecedor;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.FornecedorRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.FornecedorService;
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
        return fornecedor.get();
    }

    @Transactional
    public Fornecedor update(Fornecedor fornecedor) {

        Fornecedor fornecedorEncontrado = findById(fornecedor.getId());

        fornecedorEncontrado.setNome(fornecedorEncontrado.getNome());
        fornecedorEncontrado.setRazao_social(fornecedorEncontrado.getRazao_social());
        fornecedorEncontrado.setNumero_documento(fornecedorEncontrado.getNumero_documento());
        fornecedorEncontrado.setTelefone(fornecedorEncontrado.getTelefone());
        fornecedorEncontrado.setTelefone2(fornecedorEncontrado.getTelefone2());
        fornecedorEncontrado.setCeluar(fornecedorEncontrado.getCeluar());
        fornecedorEncontrado.setWhatsapp(fornecedorEncontrado.getWhatsapp());
        fornecedorEncontrado.setEmail(fornecedorEncontrado.getEmail());
        fornecedorEncontrado.setEmail2(fornecedorEncontrado.getEmail2());
        fornecedorEncontrado.setCep(fornecedorEncontrado.getCep());
        fornecedorEncontrado.setLogradouro(fornecedorEncontrado.getLogradouro());
        fornecedorEncontrado.setNumero(fornecedorEncontrado.getNumero());
        fornecedorEncontrado.setComplemento(fornecedorEncontrado.getComplemento());
        fornecedorEncontrado.setBairro(fornecedorEncontrado.getBairro());
        fornecedorEncontrado.setCidade(fornecedorEncontrado.getCidade());
        fornecedorEncontrado.setEstado(fornecedorEncontrado.getEstado());
        fornecedorEncontrado.setPais(fornecedorEncontrado.getPais());

        Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedorEncontrado);

        return fornecedorAtualizado;
    }

    @Override
    public void deleteById(UUID id) {

        Fornecedor fornecedor = findById(id);

        fornecedorRepository.deleteById(fornecedor.getId());

    }

}
