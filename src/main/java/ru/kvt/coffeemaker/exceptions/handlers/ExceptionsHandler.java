package ru.kvt.coffeemaker.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kvt.coffeemaker.exceptions.CoffeeMakerDisabledException;
import ru.kvt.coffeemaker.exceptions.CoffeeMakerError;

import javax.validation.ConstraintViolationException;


@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        CoffeeMakerError err = new CoffeeMakerError(HttpStatus.BAD_REQUEST.value() , HttpStatus.BAD_REQUEST.getReasonPhrase(), "Введите значение от 0 до 100");
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        CoffeeMakerError err = new CoffeeMakerError(HttpStatus.BAD_REQUEST.value() , HttpStatus.BAD_REQUEST.getReasonPhrase(), "Выберите один из режимов: WATER/VAPOR");
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler
    public ResponseEntity<?> handleCoffeeMakerDisabledException(CoffeeMakerDisabledException e) {
        CoffeeMakerError err = new CoffeeMakerError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), "Кофеварка выключена. Включите кофеварку для работы с ней");
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
