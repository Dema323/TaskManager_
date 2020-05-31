package com.example.demo.domain;

import com.example.demo.domain.Subtask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
public class SubtaskTest {

    @Test
    public void setterAndGetterTest(){
        Subtask subtask = new Subtask();
        subtask.setId(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2186b889"));
        subtask.setName("title");
        subtask.setDescription("description");

        assertNotNull(subtask);
        assertEquals(UUID.fromString("950889d8-b49d-4ce0-bcd0-228a2186b889"),subtask.getId());
        assertEquals("title",subtask.getName());
        assertEquals("description",subtask.getDescription());
    }
}
