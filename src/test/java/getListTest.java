import Todo.dto.TodoDTO;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class getListTest {
    @Test
    public void getList(){
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setLocalDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        System.out.println(todoDTOS);
    }
}
