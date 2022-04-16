package repository;
import model.Product;

public interface IProductRepository extends ICrudRepository<Product> {
    Product findById(int id);

    void edit(int id, Product product);
}
