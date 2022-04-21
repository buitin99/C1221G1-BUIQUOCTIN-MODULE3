package controller;

import model.RentType;
import model.Service;
import model.ServiceType;
import service.IService;
import service.IServiceType;
import service.impl.RentTypeImpl;
import service.impl.ServiceImpl;
import service.impl.ServiceTypeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet" , urlPatterns = {"/service"})
public class ServiceController extends HttpServlet {

    private IService iService = new ServiceImpl();
    private ServiceTypeImpl serviceType = new ServiceTypeImpl();
    private RentTypeImpl rentType = new RentTypeImpl();

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
                createService(request,response);
                break;

            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            default:
                listService(request,response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceType> serviceTypes = serviceType.getList();
        request.setAttribute("serviceType", serviceTypes);
        List<Service> serviceList = iService.getList();
        request.setAttribute("serviceList",serviceList);
        List<RentType> rentTypeList = rentType.getList();
        request.setAttribute("rentType", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceType> serviceTypes = serviceType.getList();
        request.setAttribute("serviceType", serviceTypes);
        List<Service> serviceList = iService.getList();
        request.setAttribute("serviceList",serviceList);
        List<RentType> rentTypeList = rentType.getList();
        request.setAttribute("rentType", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/service/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = null;
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double cost = Double.valueOf(request.getParameter("cost"));
        Integer peoples = Integer.parseInt(request.getParameter("peoples"));
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        Integer typeIdService = Integer.parseInt(request.getParameter("typeIdService"));
        String standard = request.getParameter("standard");
        String describe = request.getParameter("describe");
        Double areaPool = Double.valueOf(request.getParameter("areaPool"));
        Integer floor = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(id,name,area,cost,peoples,typeId,typeIdService,standard,describe,areaPool,floor);
        Map<String, String> map = iService.save(service);
        if (map.isEmpty()){
            response.sendRedirect("/service");
        }else {
            request.setAttribute("error",map);
            request.getRequestDispatcher("/views/service/create.jsp").forward(request,response);
        }
    }
}
