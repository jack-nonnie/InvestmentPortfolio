package ee552.investment.portfolio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Search </h1>");
        writer.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
