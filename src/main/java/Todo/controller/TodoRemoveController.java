package Todo.controller;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRemoveController", urlPatterns = "/todo/remove")
@Log4j2
public class TodoRemoveController extends HttpServlet {
    private TodoService service = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        log.info("tno : " + tno);

        try{
            service.remove(tno);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("read Error");
        }
        res.sendRedirect("/todo/list");
    }
}
