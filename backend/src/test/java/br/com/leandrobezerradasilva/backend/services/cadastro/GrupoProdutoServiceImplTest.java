package br.com.leandrobezerradasilva.backend.services.cadastro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.leandrobezerradasilva.backend.models.cadastro.GrupoProduto;

@SpringBootTest
public class GrupoProdutoServiceImplTest {

    @Autowired
    private GrupoProdutoServiceImpl grupoProdutoServiceImpl;

    @Test
    void testDeleteById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    @DisplayName("Deve salvar um grupo de produto.")
    void testSave() {
        GrupoProduto grupoProduto = new GrupoProduto();
        grupoProduto.setId(null);
        grupoProduto.setGrupo("Teste");
        grupoProduto.setAtivo(true);

        grupoProdutoServiceImpl.save(grupoProduto);

        assertEquals(grupoProduto, grupoProduto);
    }

    @Test
    void testUpdate() {

    }
}
