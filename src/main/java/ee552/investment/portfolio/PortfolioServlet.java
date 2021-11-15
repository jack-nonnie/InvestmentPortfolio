package ee552.investment.portfolio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/portfolio")
public class PortfolioServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Portfolio positions = new Portfolio();
        Stock stock1 = new Stock("EXP", "1.2", "1.4", "1.1", "1.3", "1.1");
        Stock stock2 = new Stock("ABC", "0.2", "0.4", "0.1", "0.3", "0.1");
        Stock stock3 = new Stock("ZYX", "2.2", "2.4", "2.1", "2.3", "2.1");
        positions.addPosition(stock1, (float) 100.4, (float) .8);
        positions.addPosition(stock2, (float) 531.2, (float) .25);
        positions.addPosition(stock3, (float) 221.4, (float) 1.8);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th> Stock Ticker </th>");
        writer.println("<th> Current Price per Share </th>");
        writer.println("<th> Number of Shares </th>");
        writer.println("<th> Current Valuation </th>");
        writer.println("<th> Amount Spent </th>");
        writer.println("<th> Percent Gain/Loss </th>");
        writer.println("</tr");
        for (int i = 0; i < positions.getSize(); i++) {
            writer.println("<tr>");
            writer.println("<th> " + positions.getStockByIndex(i).getTicker() + "</th>");
            writer.println("<th> " + String.valueOf(positions.getStockByIndex(i).getCurrentPrice()) + "</th>");
            writer.println("<th> " + String.valueOf(positions.getPostionByIndex(i)) + "</th>");
            writer.println("<th> " + String.valueOf(positions.getCurrentValueOfAPositionByIndex(i)) + "</th>");
            writer.println("<th> " + String.valueOf(positions.getOriginalPriceByIndex(i)) + "</th>");
            writer.println("<th> " + String.valueOf(positions.getPercentChangeByIndex(i)) + "</th>");
            writer.println("</tr>");
        }

        writer.println("</table>");
        writer.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}