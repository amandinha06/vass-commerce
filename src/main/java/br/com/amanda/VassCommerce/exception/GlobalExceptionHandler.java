package br.com.amanda.VassCommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarErroValidacao(
            MethodArgumentNotValidException ex
    ){

        List<Map<String, String>> campos = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> Map.of(
                        "name", erro.getField(),
                        "message" , erro.getDefaultMessage()
                ))
                .toList();
        Map<String, Object> resposta = Map.of(
                "error", "Invalid input",
                "fields", campos
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }

}
