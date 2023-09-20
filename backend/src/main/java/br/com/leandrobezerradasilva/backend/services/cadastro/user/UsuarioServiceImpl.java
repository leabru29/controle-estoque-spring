package br.com.leandrobezerradasilva.backend.services.cadastro.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.user.Usuario;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.user.UsuarioRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.UsuarioService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(UUID id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario
                .orElseThrow(
                        () -> new EntidadeNaoEncontradaException("Não foi encontrado nenhum Usuario com Id: " + id));
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario update(Usuario usuario) {
        var id = usuario.getId();
        Usuario usuarioEncontrado = findById(id);
        usuarioEncontrado.setNome(usuario.getNome());
        usuarioEncontrado.setSobrenome(usuario.getSobrenome());
        usuarioEncontrado.setEmail(usuario.getEmail());
        usuarioEncontrado.setSenha(usuario.getSenha());
        Usuario usuarioAtualizado = usuarioRepository.save(usuarioEncontrado);
        return usuarioAtualizado;
    }

    @Override
    public void deleteById(UUID id) {
        Usuario idUsuario = findById(id);
        this.usuarioRepository.deleteById(idUsuario.getId());
    }

}
