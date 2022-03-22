import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloCookie extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        if (username != null && password != null) {
            Cookie cookie = new Cookie("username", username);
            Cookie cookie1 = new Cookie("password", password);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.addCookie(cookie1);
        } else {
            for (Cookie c : httpServletRequest.getCookies()) {
                if (c.getName().equals("username")) {
                    username = c.getValue();
                }
                if (c.getComment().equals("password")) {
                    password = c.getValue();
                }

            }
        }
        httpServletResponse.getWriter().println(username + password);
    }
}