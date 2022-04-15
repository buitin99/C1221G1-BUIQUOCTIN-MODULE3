package repository;

import model.Product;

import java.util.List;

public interface IProductService<E> {
    List<Product> getList();
    void create(E e);
    void update(int id, Product product);
    void remove(int id);
    Product findByName(String name);
}
