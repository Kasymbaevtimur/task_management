package com.example.taskmanagement.model.mapper;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.dto.TaskRequest;
/**
 * <p>Класс маппер для задачи {@link Task} </p>
 * <p>Преобразует обьект типа {@link TaskRequest} в тип {@link Task}</p>
 */
public class TaskMapper {

    public static Task mapTaskRequestToTask(TaskRequest taskRequest){
        return Task.builder()
                .description(taskRequest.getDescription())
                .done(taskRequest.isDone()).build();
    }
}
