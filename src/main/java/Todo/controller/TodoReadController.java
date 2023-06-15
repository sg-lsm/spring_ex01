package Todo.controller;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("/todo/read");
        Long tno = Long.parseLong(req.getParameter("tno"));
//        TodoDTO dto = TodoService.INSTANCE.getDto(tno);
//        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/WEB-INF/todo/TodoRead.jsp").forward(req,res);
    }
}
