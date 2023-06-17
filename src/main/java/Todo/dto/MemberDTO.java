package Todo.dto;

import lombok.*;

// 서비스 계층과 컨트롤러에서 사용할 것

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
