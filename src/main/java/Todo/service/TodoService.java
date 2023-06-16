package Todo.service;

import Todo.dao.TodoDAO;
import Todo.domain.TodoVO;
import Todo.dto.TodoDTO;
import Todo.util.MapperUtil;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
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
//        System.out.println("TodoVo : " + vo);
        log.info(vo);
        dao.insert(vo);
    }

    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> voList = dao.selectAll();
        log.info("voList.....  : " + voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo->mapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
    public TodoDTO getDto(Long tno) throws Exception{
        log.info("tno : " + tno);
        TodoVO vo = dao.searchByTno(tno);
        TodoDTO dto = mapper.map(vo, TodoDTO.class);
        return dto;
    }

    public void remove(Long tno) throws Exception{
        log.info("tno : " + tno);
        dao.deleteByTno(tno);
    }

    public void modify(TodoDTO dto) throws Exception{
        log.info("todoDTO : " + dto);
        TodoVO vo = mapper.map(dto, TodoVO.class);
        dao.updateOne(vo);
    }
}
