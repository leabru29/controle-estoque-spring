package br.com.leandrobezerradasilva.backend.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
        error.setError("Entidade nao encontrada");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
