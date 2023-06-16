package Todo.controller;

import Todo.dto.MemberDTO;
import Todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("login... GET");
        req.getRequestDispatcher("/WEB-INF/Login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("login... POST");
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            res.sendRedirect("/todo/list");
        }catch (Exception e){
            // 에러 발생 시 result 파라미터를 전달해서 문제발생을 알리기 위해
            res.sendRedirect("/login?result=error");
        }

    }
}
