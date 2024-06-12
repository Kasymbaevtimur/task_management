package com.example.taskmanagement.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Класс DTO для показа данных бизнес исключений.
 */
@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String exceptionName;
    private String message;
}
