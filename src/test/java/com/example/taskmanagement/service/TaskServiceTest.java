package com.example.taskmanagement.service;

import com.example.taskmanagement.exception.TaskNotFoundException;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.dto.TaskRequest;
import com.example.taskmanagement.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

/**
 * Тестовый класс. Используется для работы тестов бизнес логики обьекта {@link Task}.
 * Применяет {@link Mockito} - для модульных тестов
 * Ипользует аннотации Lombok
 * {@link FieldDefaults} добавляет ко всем полям окончательный и приватный модификаторы
 */
@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskServiceTest {
    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Test
    void createTask() {
        taskService.createTask(TaskRequest.builder().build());
        Mockito.verify(taskRepository, Mockito.times(1)).save(Mockito.any(Task.class));
    }

    @Test
    void updateTaskById() {
        Mockito.when(taskRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Task.builder().build()));
        taskService.updateTaskById(1L, TaskRequest.builder().build());
        Mockito.verify(taskRepository, Mockito.times(1)).save(Mockito.any(Task.class));
    }

    @Test
    void getTaskById() {
        Mockito.when(taskRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Task.builder().build()));
        taskService.getTaskById(1L);
        Mockito.verify(taskRepository, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    void deleteTaskById() {
        Mockito.when(taskRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Task.builder().build()));
        taskService.deleteTaskById(1L);
        Mockito.verify(taskRepository, Mockito.times(1)).delete(Mockito.any(Task.class));
    }

    @Test
    void getTaskByIdThrowsException() {
        Assertions.assertThrows(TaskNotFoundException.class,
                () -> taskService.getTaskById(1L));
    }

    @Test
    void updateTaskByIdThrowsException() {
        Assertions.assertThrows(TaskNotFoundException.class,
                () -> taskService.updateTaskById(1L, new TaskRequest()));
    }

    @Test
    void deleteTaskByIdThrowsException() {
        Assertions.assertThrows(TaskNotFoundException.class,
                () -> taskService.deleteTaskById(1L));
    }
}
