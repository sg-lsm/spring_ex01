package Todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor // 파라미터가 없는 생성자를 생성
@AllArgsConstructor // 모든 필드값이 필요한 생성자를 생성
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate localDate;
    private boolean finished;
}
