
package works.buddy.samples;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

public class WorksWithHerokuServletTest {

    @Test
    public void testDoGet() throws Exception {
        WorksWithHerokuServlet servlet = new WorksWithHerokuServlet();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        Mockito.when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        writer.flush();
        String output = stringWriter.toString();

        assertTrue(output.contains("Buddy Works with Heroku"));
    }
}
