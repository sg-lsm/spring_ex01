package Todo.controller;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/regist")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService service = TodoService.INSTANCE;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("/todo/register GET ... ");

        HttpSession session = req.getSession();

        if(session.isNew()){
            log.info("JSESSIONID 쿠키 새로 생성된 사용자");
            res.sendRedirect("/login");
            return;
        }

        if(session.getAttribute("loginInfo") == null){
            log.info("로그인 정보가 없는 사용자");
            res.sendRedirect("/login");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/todo/TodoRegister.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        TodoDTO dto = TodoDTO.builder()
                .title(req.getParameter("title"))
                .localDate(LocalDate.parse(req.getParameter("localDate"),formatter))
                .build();
        log.info("/todo/register POST.... ");
        log.info(dto);
        try{
            service.regist(dto);
        }catch (Exception e){
            log.info(e.getMessage());
            e.printStackTrace();
        }
        res.sendRedirect("/todo/list");
    }
}
