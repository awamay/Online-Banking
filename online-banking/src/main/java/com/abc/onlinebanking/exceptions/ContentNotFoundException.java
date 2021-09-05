package com.abc.onlinebanking.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer Not Found")
public class ContentNotFoundException extends Exception{

    public ContentNotFoundException() {
        super();
    }

    public ContentNotFoundException(String message) {
        super(message);
        //this.message = message;
    }
}
