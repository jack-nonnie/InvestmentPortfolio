package ee552.portfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Autowired
    private Environment env;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(env.getProperty("apiKey"));
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
        String url = "https://finnhub.io/api/v1/quote?symbol=" + ticker + "&token=" + env.getProperty("apiKey");
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpRequest finnRequest = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        try {
            HttpResponse<String> finnResponse = client.send(finnRequest, handler);
            System.out.println(finnResponse.body());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.println("</html>");

    }

}
