package com.example.demo.controller;

import com.example.demo.domain.Task;
import com.example.demo.repository.DatabaseException;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import com.example.demo.service.TaskServicempl;
import dto.SubtaskDTO;
import dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskRepository repository){
        this.taskService = new TaskServicempl(repository);
        this.taskService.addTask(TaskDTO.create(UUID.randomUUID(),"Test_Title","Test_Description", LocalDateTime.now(),new ArrayList<>()));
        }

    @GetMapping("/")
    public String getNav(){
        return "index";
    }


    // GetTasks
    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", this.taskService.getTasks());
        return "tasks";
    }


//ADD TASKS
    @GetMapping("/tasks/new")
    public String getCreateForm(Model model) {
        model.addAttribute("task", new TaskDTO());
        return "create";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute @Valid TaskDTO taskdto, BindingResult binding){
        if(binding.hasErrors()) return "create";
        this.taskService.addTask(taskdto);
        return "redirect:/tasks";
    }









    @GetMapping("/tasks/{id}")
    public String getTaskById(@PathVariable("id") UUID id, Model model) {
        String error = "test";
        try{
            model.addAttribute("task", taskService.getTaskById(id));
            return "description";
        }catch (DatabaseException| EntityNotFoundException | NumberFormatException e){
            error = "Task not found.";
        }
        model.addAttribute("error",error);
        return "error";
    }


    //EDIT TASKS
    @GetMapping("/tasks/edit/{id}")
    public String editTaskById(@PathVariable("id") UUID id, Model model) {
        TaskDTO taskDTO = this.taskService.getTaskById(id);
        model.addAttribute("task", taskDTO);
        return "edit";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTaskByIdPost(@PathVariable UUID id, @ModelAttribute @Valid TaskDTO taskdto, BindingResult binding, Model model){
        if (binding.hasErrors()){
            TaskDTO t = this.taskService.getTaskById(id);
            model.addAttribute("task", t);
            return "edit";
        }
        taskService.editTask(taskdto);
        return "redirect:/tasks/" + taskdto.getId();
    }


    //ADD SUBTASK

    @GetMapping("/tasks/{id}/sub/create")
    public String newSubtask(@PathVariable UUID id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("subtask", new SubtaskDTO());
        return "addsubtask";
    }

    @PostMapping("tasks/{id}/sub/create")
    public String newSubtaskPost(@PathVariable UUID id, @ModelAttribute @Valid SubtaskDTO subtaskDTO, BindingResult binding, Model model){
        if(binding.hasErrors()){
            model.addAttribute("id",id);
            return "addsubtask";
        }
        this.taskService.addSubtask(id, subtaskDTO);
        return "redirect:/tasks/" + id;
    }


}
