package dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDTO {
    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    private UUID id;
    private List<SubtaskDTO> subtasks;

    public TaskDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSubtasks(List<SubtaskDTO> subtasks) {
        this.subtasks = subtasks;
    }

    public List<SubtaskDTO> getSubtasks() {
        return this.subtasks;
    }

    public static TaskDTO create(UUID id, String title, String description, LocalDateTime datetime, ArrayList<SubtaskDTO> subtaskDTOS){
        TaskDTO dto = new TaskDTO();
        dto.setId(id);
        dto.setName(title);
        dto.setDescription(description);
        dto.setDateTime(datetime);
        dto.setSubtasks(subtaskDTOS);
        return dto;
    }
}
