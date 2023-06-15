package Todo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/regist")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/regist" + "//" + "입력 화면을 볼 수 있도록 구성");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/TodoRegister.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/regist" + "//" + "입력 결과를 처리할 수 있도록 구성");
        res.sendRedirect("/todo/list");
    }
}
