package Todo.controller;

import Todo.dto.TodoDTO;
import Todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = false;
            if(todoListStr != null && todoListStr.indexOf(tno+"-")>=0){
                exist = true;
            }

            log.info("exist : " + exist);

            if(!exist){
                todoListStr += tno+"-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60*60*24);
                viewTodoCookie.setPath("/");
                res.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/TodoRead.jsp").forward(req, res);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ServletException("read error");
        }
    }

    // req.getCookies()가 Cookie배열을 반환하므로 Cookie[] cookies
    private Cookie findCookie(Cookie[] cookies, String cookieName){
        Cookie targetCookie = null;

        if(cookies != null && cookies.length>0){
            for(Cookie ck:cookies){
                if(ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                }
            }
        }

        if(targetCookie == null){
            // new Cookie (name, value)
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);
        }
        return targetCookie;
    }
}

