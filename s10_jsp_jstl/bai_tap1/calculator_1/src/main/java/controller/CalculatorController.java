package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorController", urlPatterns = {"/calculate","/"})
public class CalculatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstOperand = 0.0d;
        Double secondOperand= 0.0d;
        String message = "";
        Character operator = request.getParameter("operator").charAt(0);
        try {
            firstOperand = Double.parseDouble(request.getParameter("first-operand"));
            secondOperand = Double.parseDouble(request.getParameter("second-operand"));
        }catch (Exception e){
            message = "Number not null!";
        }

        Double result = calculate(firstOperand,secondOperand,operator);
        request.setAttribute("result",result);
        request.setAttribute("message",message);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
    public static Double calculate(Double firstOperand, Double secondOperand, Character operator) {
        switch (operator){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
