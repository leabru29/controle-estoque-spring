package br.com.leandrobezerradasilva.backend.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.leandrobezerradasilva.backend.services.exceptions.CamposInvalidos;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<PadraoMsgErro> entidadeNaoEncontrada(EntidadeNaoEncontradaException e,
            HttpServletRequest request) {
        PadraoMsgErro error = new PadraoMsgErro();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(e.getLocalizedMessage());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<CamposInvalidos>> erroValidacaoCampos(MethodArgumentNotValidException e,
            HttpServletRequest request) {

        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();

        List<CamposInvalidos> list = new ArrayList<>();

        fieldErrorList.forEach(error -> {
            list.add(new CamposInvalidos(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<PadraoMsgErro> campoDuplicado(DataIntegrityViolationException e, HttpServletRequest request) {
        PadraoMsgErro erro = new PadraoMsgErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.CONFLICT.value());
        erro.setError("Registro duplicado.");
        erro.setMessage("Verifique se os dados estão corretos e se o campo não está repetido.");
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}
