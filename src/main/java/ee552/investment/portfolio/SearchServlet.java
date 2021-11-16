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
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Search </h1>");
        writer.println("<form action= '/search' method='post'>");
        writer.println("<label> Ticker");
        writer.println("<input type='text' name='ticker'/>");
        writer.println("</label>");
        writer.println("<input type='submit' value='Submit'/>");
        writer.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ticker = request.getParameter("ticker");
        System.out.println(ticker);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Search </h1>");
        writer.println("<form action= '/search' method='post'>");
        writer.println("<label> Ticker");
        writer.println("<input type='text' name='ticker'/>");
        writer.println("</label>");
        writer.println("<input type='submit' value='Submit'/>");
        writer.println("<h2> " + ticker + "</h2>");
        writer.println("</html>");

    }

}
