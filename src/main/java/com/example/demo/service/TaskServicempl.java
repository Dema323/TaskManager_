package com.example.demo.service;

import com.example.demo.domain.Subtask;
import com.example.demo.domain.Task;
import com.example.demo.dto.SubtaskDTO;
import com.example.demo.dto.TaskDTO;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServicempl implements TaskService {

    @Autowired
    private final TaskRepository repository;

    @Autowired
    public TaskServicempl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public List<TaskDTO> getTasks(){
        return repository.findAll().stream().map(h -> {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setName(h.getName());
            taskDTO.setDescription(h.getDescription());
            taskDTO.setDateTime(h.getDateTime());
            taskDTO.setId(h.getId());
            return  taskDTO;
        }).collect(Collectors.toList());
    }

   @Override
    public void addTask(TaskDTO taskdto){
        Task task = new Task();
        task.setName(taskdto.getName());
        task.setId(taskdto.getId());
        task.setDescription(taskdto.getDescription());
        task.setDateTime(taskdto.getDateTime());
        repository.save(task);
   }

   @Override
   public void editTask(TaskDTO taskdto){
        Task task = repository.getOne(taskdto.getId());
        task.setName(taskdto.getName());
        task.setDescription(taskdto.getDescription());
        task.setDateTime(taskdto.getDateTime());
        repository.save(task);
   }

   @Override
   public void deleteTask(UUID id){
        this.repository.deleteById(id);
   }

   @Override
    public TaskDTO getTaskById(UUID id){
       Task task = repository.getOne(id);
       if(task == null)throw new EntityNotFoundException("Task not found");

       TaskDTO taskDTO = new TaskDTO();
       taskDTO.setId(task.getId());
       taskDTO.setName(task.getName());
       taskDTO.setDescription(task.getDescription());
       taskDTO.setDateTime(task.getDateTime());

       taskDTO.setSubtasks(task.getSubtasks()
               .stream().map(h -> {
                   SubtaskDTO subtaskDTO = new SubtaskDTO();
                   subtaskDTO.setId(h.getId());
                   subtaskDTO.setName(h.getName());
                   subtaskDTO.setDescription(h.getDescription());

                   return subtaskDTO;
               }).collect(Collectors.toList())
       );

       return taskDTO;
   }





    //return Convert.taskToDto(this.repository.getOne(id));
   @Override
    public void addSubtask(UUID id, SubtaskDTO subtaskDTO){
       Subtask subtask = new Subtask();
       subtask.setName(subtaskDTO.getName());
       subtask.setDescription(subtaskDTO.getDescription());
       subtask.setId(subtaskDTO.getId());
        Task task = this.repository.getOne(id);
        task.addSubtask(subtask);
        this.repository.save(task);
   }

}
