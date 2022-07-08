package kstu.kg.VuefProjectBack.exception;

import kstu.kg.VuefProjectBack.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class UserNotCorrectPasswordException extends BaseException {
    public UserNotCorrectPasswordException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
