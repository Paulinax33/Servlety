import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class ServletController extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletRequest
                .getRequestDispatcher("/aa.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        String password = httpServletRequest.getParameter("password");
        String login = httpServletRequest.getParameter("login");
        httpServletRequest.setAttribute("password", password);
        httpServletRequest.setAttribute("login", login);
        httpServletRequest
                .getRequestDispatcher("/bb.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }
}