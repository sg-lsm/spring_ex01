package org.lsm.service;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class TodoServiceTest {
    private TodoService service;
    @BeforeEach
    public void ready(){
        service = TodoService.INSTANCE;
    }

    @Test
    public void registerTest() throws Exception{
        TodoDTO dto = TodoDTO.builder()
                .title("testDTO")
                .localDate(LocalDate.now())
                .build();
        service.regist(dto);
    }
}
