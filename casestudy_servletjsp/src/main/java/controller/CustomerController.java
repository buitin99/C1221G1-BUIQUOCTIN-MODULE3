package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomeTypeService;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FuramaController", urlPatterns = {"/customer"})
public class CustomerController extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerServiceImpl();
    private ICustomeTypeService iCustomeTypeService = new CustomerTypeImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "search":
                String name = request.getParameter("nameSearch");
                String phone = request.getParameter("phoneSearch");
                String typeId = request.getParameter("typeSearch");
                List<Customer> customerList = iCustomerService.search(name,phone,typeId);
                request.setAttribute("customerList",customerList);
                List<CustomerType> customerTypeList = iCustomeTypeService.getListCustomerType();
                request.setAttribute("customerTypeList",customerTypeList);
                request.getRequestDispatcher("/views/customer/list.jsp").forward(request,response);
                break;
            default:
                listCustomer(request,response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomeTypeService.getListCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomeTypeService.getListCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        List<Customer> customerList = iCustomerService.getListCustomer();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/customer/list.jsp");
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String idCard = request.getParameter("idCard");
        Integer id = null;
        Customer customer = new Customer(id,idType,name,dateOfBirth,gender,phone,email,address,idCard);
        Map<String, String> map = iCustomerService.save(customer);
        if (map.isEmpty()){
            response.sendRedirect("/customer");
        }else
        {
            request.setAttribute("error",map);
            request.getRequestDispatcher("/views/customer/create.jsp").forward(request,response);
        }
    }

}





