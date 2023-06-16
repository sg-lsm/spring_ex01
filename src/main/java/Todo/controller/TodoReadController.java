package Todo.controller;

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

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {
    private TodoService service = TodoService.INSTANCE;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try{
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO dto = service.getDto(tno);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/TodoRead.jsp").forward(req, res);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ServletException("read error");
        }
    }
}

