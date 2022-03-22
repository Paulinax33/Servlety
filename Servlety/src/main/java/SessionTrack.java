import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class SessionTrack extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a session object if it is already not  created.
        HttpSession session = request.getSession(true);
        // Get session creation time.
        Date createTime = new Date(session.getCreationTime());
        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        int visitCount = 0;
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID;
        // Check if this is new comer on your web page.
        if (session.isNew()) {
            userID = UUID.randomUUID().toString();
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer)session.getAttribute(visitCountKey);
            visitCount++;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,  visitCount);
        response.getWriter().println("id: " + session.getId());
        response.getWriter().println("time: " + createTime);
        response.getWriter().println("last access time: " + lastAccessTime);
        response.getWriter().println("user id: " + userID);
        response.getWriter().println("visit count: " + visitCount);
        response.getWriter().println("Hello World!");
    }
}