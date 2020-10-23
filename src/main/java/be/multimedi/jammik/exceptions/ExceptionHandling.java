package be.multimedi.jammik.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Gemaakt door Jan
 */
public class ExceptionHandling {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity.badRequest().build();
    }
}