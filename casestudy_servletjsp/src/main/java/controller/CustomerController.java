package controller;

import model.Customer;
import model.CustomerType;
import model.Service;
import service.ICustomeTypeService;
import service.ICustomerService;
import service.IService;
import service.impl.CustomerServiceImpl;
import service.impl.CustomerTypeImpl;
import service.impl.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
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
            case "edit":
                showEditForm(request,response);
                break;
            default:
                listCustomer(request,response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/customer/edit.jsp");
        request.setAttribute("customer",customer);
        List<CustomerType> customerTypeList = iCustomeTypeService.getListCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        try {
           dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
                updateCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.deleteCustomer(id);
        response.sendRedirect("/customer");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Integer customerTypeId = Integer.valueOf(request.getParameter("customerType"));
        String customerName = request.getParameter("name");
        String customerBirthday = request.getParameter("dateOfBirth");
        Integer customerGender = Integer.valueOf(request.getParameter("gender"));
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("address");
        String customerIdCard = request.getParameter("idCard");
        Customer customerUpdate = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender
                , customerPhone, customerEmail,  customerIdCard, customerAddress);
        RequestDispatcher dispatcher;
        iCustomerService.updateCustomer(customerUpdate);
        dispatcher = request.getRequestDispatcher("/views/customer/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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





