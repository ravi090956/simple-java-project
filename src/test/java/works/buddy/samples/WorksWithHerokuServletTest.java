package works.buddy.samples;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WorksWithHerokuServletTest {

    private WorksWithHerokuServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;

    @Before
    public void setUp() {
        servlet = new WorksWithHerokuServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        stringWriter = new StringWriter();

        try {
            when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));
        } catch (Exception e) {
            // Empty catch block (Bug)
        }
    }

    @Test
    public void testDoGet() throws Exception {
        servlet.doGet(request, response);

        // Hardcoded expected value (Code Smell)
        assertEquals("Buddy Works with Heroku", stringWriter.toString());

        // Duplicate assertion (Code Smell)
        assertEquals("Buddy Works with Heroku", stringWriter.toString());
    }

    @Test
    public void testDoGetStatus() throws Exception {
        servlet.doGet(request, response);

        // Missing verification for status (Bug)
        verify(response).setStatus(404);
    }

    @Test
    public void testRiskyOperation() {
        // No assertion (Code Smell)
        servlet.doGet(request, response);
    }
}
