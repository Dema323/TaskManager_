package com.example.demo.dto;

import com.example.demo.dto.SubtaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubtaskDTOTest {

    @Test
    public void setterAndGetterTest(){
        SubtaskDTO subtask = new SubtaskDTO();
        subtask.setId(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"));
        subtask.setName("title");
        subtask.setDescription("description");

        assertNotNull(subtask);
        assertEquals(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2086b889"),subtask.getId());
        assertEquals("title",subtask.getName());
        assertEquals("description",subtask.getDescription());
    }

}