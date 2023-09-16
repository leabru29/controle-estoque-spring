package br.com.leandrobezerradasilva.backend.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CamposInvalidos {
    private String field;
    private String message;

}
