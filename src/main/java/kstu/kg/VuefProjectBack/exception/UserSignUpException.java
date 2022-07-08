package kstu.kg.VuefProjectBack.exception;

import kstu.kg.VuefProjectBack.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class UserSignUpException extends BaseException {
    public UserSignUpException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
