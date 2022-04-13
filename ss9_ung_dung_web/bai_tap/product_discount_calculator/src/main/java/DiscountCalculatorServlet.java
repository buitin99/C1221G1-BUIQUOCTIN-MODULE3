import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountCalculatorServlet", value = "/display_discount")
public class DiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double LD = Double.parseDouble(request.getParameter("LP"));
        double DP = Double.parseDouble(request.getParameter("DP"));
        double DA = LD*DP*0.01;
        double KQ = LD - DA;
        request.setAttribute("ketQuaGiaGiam", DA);
        request.setAttribute("ketQuaSauCung", KQ);
        request.getRequestDispatcher("/display_discount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double LD = Double.parseDouble(request.getParameter("LP"));
        double DP = Double.parseDouble(request.getParameter("DP"));
        double DA = LD*DP*0.01;
        double KQ = LD - DA;
        request.setAttribute("ketQuaGiaGiam", DA);
        request.setAttribute("ketQuaSauCung", KQ);
        request.getRequestDispatcher("/display_discount.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }
}
