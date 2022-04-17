package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> getListProduct() {
        List<Product> productList = iProductRepository.getList();
        return productList;
    }

    @Override
    public Map<String, String> save(Product product) {
        Map<String, String>map = new HashMap<>();
        if(product.getName().equals("")){
            map.put("name","Tên Sản Phẩm Không Được Để Trống!");
        } else if(!product.getName().matches("^[a-zA-Z]+$")){
            map.put("name","Tên Sản Phẩm Không Hợp Lệ!");
        }

        if(map.isEmpty()){
            iProductRepository.save(product);
        }
        return map;
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }

    @Override
    public Product findById(int id) {
        Product product = iProductRepository.findById(id);
        return product;
    }

//    @Override
//    public void edit(int id, Product product) {
//        iProductRepository.edit(id,product);
//    }
//
//    @Override
//    public void updateProduct(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        Double price = Double.parseDouble(request.getParameter("price"));
//        String describe = request.getParameter("describe");
//        String produce = request.getParameter("produce");
//        Product product = this.iProductRepository.findById(id);
//        RequestDispatcher dispatcher;
//        if (product == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else
//        {
//            product.setName(name);
//            product.setPrice(price);
//            product.setDescribe(describe);
//            product.setProduce(produce);
//            this.iProductRepository.edit(id,product);
//            request.setAttribute("product",product);
//            request.setAttribute("message","Product information was updated");
//            dispatcher = request.getRequestDispatcher("edit.jsp");
//        }
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductRepository.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductRepository.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductRepository.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else
        {
            this.iProductRepository.remove(id);
        }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductRepository.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else
        {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProducts(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String produce = request.getParameter("produce");
        Product product = this.iProductRepository.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else
        {
            product.setName(name);
            product.setPrice(price);
            product.setDescribe(describe);
            product.setProduce(produce);
            this.iProductRepository.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
