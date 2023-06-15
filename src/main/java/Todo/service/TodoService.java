package Todo.service;

import Todo.dao.TodoDAO;
import Todo.domain.TodoVO;
import Todo.dto.TodoDTO;
import Todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;
    private TodoDAO dao;
    private ModelMapper mapper;

    TodoService(){
        dao = new TodoDAO();
        mapper = MapperUtil.INSTANCE.get();
    }

    // TodoDto를 인자로 받아 Vo로 변환하는 과정을 거쳐 dao.insert()를 실행하여 vo(dto변환)를 등록한다.
    public void regist(TodoDTO dto) throws Exception{
        TodoVO vo = mapper.map(dto, TodoVO.class);
        System.out.println("TodoVo : " + vo);
        dao.insert(vo);
    }
}
