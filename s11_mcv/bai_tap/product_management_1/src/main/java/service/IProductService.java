package service;
import model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getListProduct();
    Map<String, String> save(Product product);
    List<Product> search(String name);
    Product findById(int id);
    void edit(int id, Product product);
    void updateProduct(HttpServletRequest request, HttpServletResponse response);
    void editProduct(HttpServletRequest request, HttpServletResponse response);
    void showDeleteForm(HttpServletRequest request, HttpServletResponse response);
    void deleteProduct(HttpServletRequest request, HttpServletResponse response);
}
