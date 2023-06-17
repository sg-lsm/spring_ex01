package Todo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Log4j2
public class loginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object obj = event.getValue();

        if(name.equals("loginInfo")){
            log.info("A user logined... ");
            log.info(obj);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {};

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {};
}
