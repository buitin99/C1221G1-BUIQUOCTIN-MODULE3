package repository;
import model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IProductRepository extends ICrudRepository<Product> {
    Product findById(int id);
    void update(int id, Product product);
    void remove (int id);
}
