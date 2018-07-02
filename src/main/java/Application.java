import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Application {
    private static final int DEFAULT_PORT =8080;
    public static void main(String[] args) throws Exception {
        int port = DEFAULT_PORT;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {}
        new Server(port) {{
            setHandler(new ServletContextHandler(){{
                           addServlet(new ServletHolder(new HttpServlet() {
                               @Override
                               protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                                   resp.getWriter().write("hello world");
                               }
                           }),"/*");
                       }}
            );
            start();
            join();
        }};
    }}
