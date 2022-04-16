package service;
import model.Product;
import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getListProduct();
    Map<String, String> save(Product product);
    List<Product> search(String name);
    Product findById(int id);
    void edit(int id, Product product);
}
