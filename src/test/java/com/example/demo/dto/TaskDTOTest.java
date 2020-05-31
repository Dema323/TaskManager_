package com.example.demo.dto;

import com.example.demo.dto.SubtaskDTO;
import com.example.demo.dto.TaskDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskDTOTest {

    @Test
    public void setterAndGetterTest(){
        TaskDTO task = new TaskDTO();
        task.setId(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"));
        task.setName("title");
        task.setDescription("description");
        LocalDateTime datime = LocalDateTime.now();
        task.setDateTime(datime);
        task.setSubtasks(new ArrayList<SubtaskDTO>());

        assertNotNull(task);
        assertEquals(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"),task.getId());
        assertEquals("title",task.getName());
        assertEquals("description",task.getDescription());
        assertEquals(datime,task.getDateTime());
    }


}