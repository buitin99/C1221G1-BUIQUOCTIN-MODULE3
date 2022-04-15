package controller;

import model.Product;
import repository.IProductRepository;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", urlPatterns = {"/product","/"})
public class ProductController extends HttpServlet {
    //mô phỏng DI
    private IProductService iProductService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":{
                createProduct(request,response);
            }
            case "edit":{
                editProduct(request,response);
            }
            case "delete":{
                deleteProduct(request,response);
            }
            case "serch":{
                serchProduct(request,response);

            }
        }
    }



    private void serchProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Product> productListFind = new ArrayList<>();
        for (Product p : this.iProductService.getListProduct()) {
            if (p.getId() == id){
                productListFind.add(p);
                request.setAttribute("productfind",productListFind);
                try {
                    request.getRequestDispatcher("serch.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Product> productListDelete = new ArrayList<>();
        for (Product p : this.iProductService.getListProduct()) {
            if (p.getId() == id){
                this.iProductService.getListProduct().remove(p);
            }else
            {
                System.out.println("Not Found Product!");
            }

        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        for (Product p : this.iProductService.getListProduct()) {
          if (p.getId() == id){
              String name = request.getParameter("name");
              Double price = Double.valueOf(request.getParameter("price"));
              String describe = request.getParameter("describe");
              String produce = request.getParameter("produce");
              Product product = new Product(id,name,price,describe,produce);
              Map<String, String> map = iProductService.save(product);
              if(map.isEmpty()){
                  try {
                      response.sendRedirect("/product");
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }else
              {
                  request.setAttribute("error", map);
                  try {
                      request.getRequestDispatcher("edit.jsp").forward(request,response);
                  } catch (ServletException e) {
                      e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Integer id = (int)(Math.random()*1000);
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String produce = request.getParameter("produce");
        Product product = new Product(id,name,price,describe,produce);
        Map<String, String> map =iProductService.save(product);
        if(map.isEmpty()){
            response.sendRedirect("/product");
        }else
        {
            request.setAttribute("error", map);
            request.getRequestDispatcher("create.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":{
                request.getRequestDispatcher("create.jsp").forward(request,response);
            }
            case "edit":{
                request.getRequestDispatcher("edit.jsp").forward(request,response);
            }
            case "delete":{
                request.getRequestDispatcher("delete.jsp").forward(request,response);
            }
            case "serch":{
                request.getRequestDispatcher("serch.jsp").forward(request,response);
            }
            default:
            showList(request,response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.getListProduct();
        request.setAttribute("products",productList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
