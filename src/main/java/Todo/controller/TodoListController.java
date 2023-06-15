package Todo.controller;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/list");
        // TodoDTO타입을 가진 List인 todoList를 생성해 값으로는 Service의 싱글톤 객체로 구현한 INSTANCE의 getList()메서드를 넣어준다.
        List<TodoDTO> todoList = TodoService.INSTANCE.getList();
        // doGet에게 list라는 이름을 가진 todoList를 넘겨주어 보관하도록 작성한다.
        req.setAttribute("list", todoList);
        // 이는 TodoList.jsp로 forward(req, res)를 통해 전해주도록 한다.
        req.getRequestDispatcher("/WEB-INF/todo/TodoList.jsp").forward(req,res);
    }
}
