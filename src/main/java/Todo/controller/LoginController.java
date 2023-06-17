package Todo.controller;

import Todo.dto.MemberDTO;
import Todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

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
        String auto = req.getParameter("auto");

        boolean rememberMe = auto != null && auto.equals("on");

        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

            if(rememberMe){
                String uuid = UUID.randomUUID().toString();
                MemberService.INSTANCE.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);

                Cookie rememberCookie = new Cookie("rememberCookie", uuid);
                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");

                res.addCookie(rememberCookie);
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            res.sendRedirect("/todo/list");
        }catch (Exception e){
            // 에러 발생 시 result 파라미터를 전달해서 문제발생을 알리기 위해
            res.sendRedirect("/login?result=error");
        }
    }
}

/* 간단하게 검증하는 로그인 && 로그인 체크 구현
    로그인
        사용자가 로그인할 때 임의의 문자열을 생성하고 이를 DB에 보관
        쿠키에는 생성된 문자열을 값으로 삼고 유효기간은 1주일로 설정
    로그인 체크
        현재 사용자의 HttpSession에 로그인 정보에 없는 경우에만 쿠키를 확인
        쿠키의 값과 DB의 값을 비교하고 사용자의 정보를 읽어와 HttpSession에 사용자 정보를 추가
*/