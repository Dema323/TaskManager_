package com.example.demo.service;

import com.example.demo.dto.SubtaskDTO;
import com.example.demo.dto.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

     List<TaskDTO> getTasks();

    void addTask(TaskDTO taskdto);

   void editTask(TaskDTO taskdto);

    void deleteTask(UUID id);

    TaskDTO getTaskById(UUID id);

    void addSubtask(UUID id, SubtaskDTO subtask);

}
