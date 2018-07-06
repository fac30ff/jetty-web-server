import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();


        PrintWriter w = resp.getWriter();
        w.write("Admin menu");
        String x = req.getParameter("x");
        w.write("\n");
        w.write("x=");
        w.write(x);
        w.write("\n");
        String pathInfo = req.getPathInfo();

        w.write(pathInfo==null ? "" : pathInfo );







        //resp.addCookie(new Cookie("u_id","5"));
        Cookie c = new Cookie("u_id", "5");
        c.setMaxAge(0);
        resp.addCookie(c);
/*
        Files.copy(
                Paths.get("", req.getPathInfo()),
                resp.getOutputStream()
        );
*/

    }
}
