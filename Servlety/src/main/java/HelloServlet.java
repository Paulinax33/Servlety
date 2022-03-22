import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello.Paulina")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException{
        int age = Integer.parseInt(httpServletRequest.getParameter( "age"));
        String name = httpServletRequest.getParameter("name");

        httpServletResponse.getWriter().println("Your age  " + name + age );

    }
}
