package com.example.taskmanagement.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Pojo DTO класс для задачи {@link com.example.taskmanagement.model.Task}
 * Используется для переноса данных со стороны клиента</p>
 * Ипользует аннотации Lombok для генерации дефолотных конструкций (конструкторы, геттеры/сеттеры...)
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskRequest {
    String description;
    boolean done;
}
