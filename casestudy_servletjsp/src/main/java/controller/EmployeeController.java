package controller;

import com.sun.webkit.dom.DocumentImpl;
import model.Division;
import model.EducateDegree;
import model.Employee;
import model.Position;
import service.IEmployee;
import service.impl.DivisionImpl;
import service.impl.EducationImpl;
import service.impl.EmployeeImpl;
import service.impl.PositionImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeController", urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {

    private EmployeeImpl employee = new EmployeeImpl();
    private DivisionImpl division = new DivisionImpl();
    private PositionImpl position = new PositionImpl();
    private EducationImpl education = new EducationImpl();
    private IEmployee iEmployee = new EmployeeImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case  "search" :
                showSearchForm(request,response);
                break;
            default:
                listEmployee(request, response);
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameSearch");
        String positions = request.getParameter("positionSearch");
        String divisions = request.getParameter("divisionSearch");
        List<Employee> employeeList = iEmployee.search(name,positions,divisions);
        request.setAttribute("employee",employeeList);
        List<Division> divisionList = division.getListDivision();
        request.setAttribute("division", divisionList);
        List<Position> positionList = position.getListPosition();
        request.setAttribute("position", positionList);
        try {
            request.getRequestDispatcher("/views/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployee.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/edit.jsp");
        request.setAttribute("employee",employee);
        List<Division> divisionList = division.getListDivision();
        request.setAttribute("division", divisionList);
        List<Position> positionList = position.getListPosition();
        request.setAttribute("position", positionList);
        List<EducateDegree> educateDegreeList = education.getListEducation();
        request.setAttribute("education", educateDegreeList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employee.getListEmployee();
        request.setAttribute("employee", employeeList);
        List<Division> divisionList = division.getListDivision();
        request.setAttribute("division", divisionList);
        List<Position> positionList = position.getListPosition();
        request.setAttribute("position", positionList);
        List<EducateDegree> educateDegreeList = education.getListEducation();
        request.setAttribute("education", educateDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employee.getListEmployee();
        request.setAttribute("employee", employeeList);
        List<Division> divisionList = division.getListDivision();
        request.setAttribute("division", divisionList);
        List<Position> positionList = position.getListPosition();
        request.setAttribute("position", positionList);
        List<EducateDegree> educateDegreeList = education.getListEducation();
        request.setAttribute("education", educateDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee/list.jsp");
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
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        iEmployee.deleteEmploye(id);
        response.sendRedirect("/employee");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId =Integer.parseInt(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        Integer divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employeeUp = new Employee(id,name,dateOfBirth,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId);
        RequestDispatcher dispatcher;
        iEmployee.updateEmployee(employeeUp);
        dispatcher = request.getRequestDispatcher("/views/employee/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        Integer divisionId =Integer.parseInt(request.getParameter("divisionId"));
        Integer id = null;
        Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId);
        Map<String, String> map = iEmployee.save(employee);
        if (map.isEmpty()) {
            response.sendRedirect("/employee");
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("/views/employee/create.jsp");
        }
    }
}
