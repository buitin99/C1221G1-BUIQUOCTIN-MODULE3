package controller;

import model.Service;
import service.IService;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Servlet" , urlPatterns = {"/service"})
public class ServiceController extends HttpServlet {

    private IService iService = new ServiceImpl();

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

    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        Integer id = null;
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
