package github.com.fercodee.rest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import github.com.fercodee.exception.RegraNegocioException;
import github.com.fercodee.rest.ApiErrors;


@RestControllerAdvice // Spring annotation to handle exceptions in controllers and return a response
public class ApplicationControllerAdvice {  

    @ExceptionHandler(RegraNegocioException.class) // Spring annotation to handle exceptions
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException exception) {
        return new ApiErrors(exception.getMessage());
    }

}
