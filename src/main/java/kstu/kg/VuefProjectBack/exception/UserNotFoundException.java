package kstu.kg.VuefProjectBack.exception;

import kstu.kg.VuefProjectBack.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
