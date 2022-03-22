import javax.servlet.*;
import java.io.IOException;

public class AFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){
    }
    @Override
    public void destroy(){
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException{
        String password = servletRequest.getParameter("password");
        if (password==null)
            throw new RuntimeException("You do not pass password");
        if(!password.equals("password"))
            throw new RuntimeException("You do not pass fit password");

        String user = servletRequest.getParameter("user");
        if(user==null)
            throw new RuntimeException("write name");
        if(!user.equals("Paulina"))
            throw new RuntimeException("your user name isn't correct");

        servletResponse.setContentType("text/html");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
