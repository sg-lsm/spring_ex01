package Todo.controller;

import Todo.domain.TodoVO;
import Todo.dto.TodoDTO;
import Todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
    private TodoService service = TodoService.INSTANCE;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO dto = service.getDto(tno);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/TodoModify.jsp").forward(req, res);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("modify get... error");
        }
        res.sendRedirect("/todo/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String finishedStr = req.getParameter("finished");

        TodoDTO dto = TodoDTO.builder()
                .tno(Long.parseLong(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .localDate(LocalDate.parse(req.getParameter("localDate"),dateTimeFormatter))
                .finished(finishedStr != null && finishedStr.equals("on"))
                .build();
        System.out.println(dto);

        log.info("/todo/modify POST...");
        log.info(dto);
        try{
            service.modify(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        res.sendRedirect("/todo/list");
    }
}