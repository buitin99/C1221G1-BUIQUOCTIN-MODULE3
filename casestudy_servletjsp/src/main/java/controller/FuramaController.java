package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaController", urlPatterns = {"/furama","/"})
public class FuramaController extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerServiceImpl() ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:
                listCustomer(request,response);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.getListCustomer();
        request.setAttribute("customers",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
