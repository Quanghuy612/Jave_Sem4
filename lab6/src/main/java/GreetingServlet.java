import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        req.setAttribute("message", "Xin chào, " + (username != null ? username : "Khách") + "!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/greet.jsp");
        dispatcher.forward(req, resp);
    }
}
