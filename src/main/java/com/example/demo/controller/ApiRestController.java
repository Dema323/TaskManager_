package com.example.demo.controller;

import com.example.demo.dto.TaskDTO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    private final TaskService taskService;

    @Autowired
    public ApiRestController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaskDTO> getTasks(){
        return this.taskService.getTasks();
    }

    @PostMapping("/task")
    public TaskDTO createNewTask(@RequestBody @Valid TaskDTO taskDTO){

        taskService.addTask(taskDTO);
        return taskDTO;
    }
}
