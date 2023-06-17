package Todo.controller;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {
    private TodoService service = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("todo list...");
        ServletContext context = req.getServletContext();
        log.info("appName : " + context.getAttribute("appName"));

        try{
            List<TodoDTO> dtoList = service.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/TodoList.jsp").forward(req, res);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
