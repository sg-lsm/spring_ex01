package Todo.service;

import Todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;
    public void register(TodoDTO todoDTO){
        System.out.println("DEBUG.." + todoDTO);
    }
    public List<TodoDTO> getList(){
        List<TodoDTO> dtoList = IntStream.range(0, 10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setLocalDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }
    public TodoDTO getDto(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("samle");
        dto.setLocalDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }
}
