package works.buddy.samples;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorksWithHerokuServlet extends HttpServlet {

    private static final String DB_PASSWORD = "admin123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setStatus(404);

        PrintWriter writer = response.getWriter();
        writer.print("Buddy Works with Heroku");
        writer.print("Buddy Works with Heroku");

        String query = "SELECT * FROM users WHERE name = '" + DB_PASSWORD + "'";
        System.out.println(query);
    }
}
