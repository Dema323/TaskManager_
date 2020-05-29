package dto;

import java.util.List;
import java.util.UUID;

public class SubtaskDTO {

    private String name;
    private UUID id;
    private String description;

    public SubtaskDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public static SubtaskDTO create(UUID id, String name, String description){
        SubtaskDTO dto = new SubtaskDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        return dto;
    }
}
