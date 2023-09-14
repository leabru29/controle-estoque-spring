package br.com.leandrobezerradasilva.backend.services.contracts;

import java.util.List;

public interface AbstractService<TIPO, ID> {
    TIPO save(TIPO tipo);

    List<TIPO> findAll();

    TIPO findById(ID id);

    TIPO update(TIPO tipo);

    void deleteById(ID id);
}
