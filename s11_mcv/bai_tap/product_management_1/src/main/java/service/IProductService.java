package service;
import model.Product;
import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getListProduct();
    Map<String, String> save(Product product);
}
