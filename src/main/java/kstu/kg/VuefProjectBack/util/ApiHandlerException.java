package kstu.kg.VuefProjectBack.util;

import kstu.kg.VuefProjectBack.exception.base.BaseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiHandlerException {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Object> handleFailException(BaseException baseException) {
        return ResponseEntity
                .status(baseException.getHttpStatus())
                .body(null);
    }
}
