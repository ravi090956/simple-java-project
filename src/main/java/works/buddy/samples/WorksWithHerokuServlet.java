package works.buddy.samples;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorksWithHerokuServlet extends HttpServlet {

    // Hardcoded password (Security Vulnerability)
    private static final String DB_PASSWORD = "admin123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setStatus(404); // Hardcoded status (Code Smell)

        PrintWriter writer = response.getWriter();

        // Duplicate print (Code Smell)
        writer.print("Buddy Works with Heroku");
        writer.print("Buddy Works with Heroku");

        // Resource leak: writer not closed properly
        // SQL Injection risk
        String query = "SELECT * FROM users WHERE name = '" + DB_PASSWORD + "'";
        System.out.println(query);
    }
}
