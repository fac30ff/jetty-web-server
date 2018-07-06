import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    public static void main(String[] args) throws Exception {
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new RootServlet()), "/*");
        handler.addServlet(new ServletHolder(new AdminServlet()), "/admin/*");

        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
