package com.example.taskmanagement.exception.handler;

import com.example.taskmanagement.exception.TaskNotFoundException;
import com.example.taskmanagement.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>Класс обработчик. Используется для обработки исключений в рамках всего приложения.</p>
 */
@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(TaskNotFoundException e) { // если сущность (task) не была найдена
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getClass().getName(), e.getMessage());
    }
}
