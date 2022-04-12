import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountCalculatorServlet", value = "/display_discount")
public class DiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double LD = Double.parseDouble(request.getParameter("LP"));
        double DP = Double.parseDouble(request.getParameter("DP"));
        double DA = LD*DP*0.01;
        double KQ = LD - DA;
        request.setAttribute("ketqua", DA);
        request.setAttribute("ketqua1", KQ);
        request.getRequestDispatcher("/display_discount.jsp").forward(request, response);
    }
}
