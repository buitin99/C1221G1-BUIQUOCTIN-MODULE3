package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = {"/customer","/"})
public class CustomerController extends HttpServlet {

    List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20","Hà Nội","https://image.thanhnien.vn/w1024/Uploaded/2022/ycwkdqmb/2022_04_10/275292915-1172159740222684-1041239282763399363-n-3652.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-20","Hà Nội","https://yt3.ggpht.com/g3j3iOUOPhNxBCNAArBqiYGzHzCBIzr_Al8mdvtBJeZMGFDblnU5rlVUt6GY01AUwm7Cp70J=s900-c-k-c0x00ffffff-no-rj"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-20","Hà Nội","https://i.ytimg.com/vi/FxBI3Y0VYSs/maxresdefault.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-20","Hà Nội","https://txp-storage.sgp1.digitaloceanspaces.com/wp-content/uploads/2020/10/3bd2dfc8263b59b9f6f92c2193015f79.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-20","Hà Nội","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsv3D-ShMuDzXaCV7RonFM9lFg6SEKERIezQ&usqp=CAU"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
