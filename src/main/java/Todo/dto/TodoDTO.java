package Todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data // getter, setter, toString, equals, hashCode등 모두 컴파일할 때 생성해준다.
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate localDate;
    private boolean finished;


}
