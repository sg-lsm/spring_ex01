package filter;

import Todo.dto.MemberDTO;
import Todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {};
    @Override
    public void destroy() {};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Login check filter... ");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") != null){
            chain.doFilter(req,res);
            return;
        }

        //세션에 loginInfo value가 없다면 쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(), "rememberCookie");

        if(cookie == null){
            res.sendRedirect("/login");
            return;
        }

        log.info("cookie 있음");
        //uuid value
        String uuid = cookie.getValue();

        try{
            MemberDTO dto = MemberService.INSTANCE.getByUUID(uuid);
            log.info("쿠키의 값으로 조회한 uuid" + dto);
            if(dto == null){
                throw new Exception("유효하지 않은 쿠키값");
            }
            session.setAttribute("loginInfo", dto);
            chain.doFilter(req, res);
        }catch (Exception e){
            e.printStackTrace();
            res.sendRedirect("/login");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName){
        if(cookies == null || cookies.length==0){
            return null;
        }
        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(cookieName))
                .findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
