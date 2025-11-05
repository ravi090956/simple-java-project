package works.buddy.samples;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WorksWithHerokuServlet extends HttpServlet {

    // Hardcoded credentials (Security Vulnerability)
    private static final String DB_PASSWORD = "admin123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        // Hardcoded status code (Code Smell)
        response.setStatus(404);

        PrintWriter writer = response.getWriter();

        // Resource leak: writer not closed in finally block
        writer.print("Buddy Works with Heroku");

        // Duplicate logic (Code Smell)
        writer.print("Buddy Works with Heroku");

        // Empty catch block (Bug)
        try {
            riskyOperation();
        } catch (Exception e) {
            // ignored
        }
    }

    private void riskyOperation() {
        // SQL Injection risk (Security Vulnerability)
        String query = "SELECT * FROM users WHERE name = '" + DB_PASSWORD + "'";
        System.out.println(query);
    }
}
