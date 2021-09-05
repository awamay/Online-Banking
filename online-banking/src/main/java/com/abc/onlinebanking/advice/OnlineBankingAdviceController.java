//package com.abc.onlinebanking.advice;
//import com.abc.onlinebanking.exceptions.*;
//import com.abc.onlinebanking.domain.ResponseErrorMessage;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class OnlineBankingAdviceController {
//    @ExceptionHandler(ContentNotFoundException.class)
//    public ResponseErrorMessage handleNotFoundException(ContentNotFoundException exception) {
//        ResponseErrorMessage errorMessage = new ResponseErrorMessage(exception.getMessage());
//        return errorMessage;
//    }
//}
