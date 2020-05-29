package com.example.demo.service;

import com.example.demo.domain.Task;
import dto.SubtaskDTO;
import dto.TaskDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    public List<TaskDTO> getTasks();

    void addTask(TaskDTO taskdto);

   void editTask(TaskDTO taskdto);

    void deleteTask(UUID id);

    TaskDTO getTaskById(UUID id);

    void addSubtask(UUID id, SubtaskDTO subtask);

}
