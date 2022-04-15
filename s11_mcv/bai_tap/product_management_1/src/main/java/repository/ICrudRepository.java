package repository;
import model.Product;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();
    void save(E e);
    List<E> search(String name);
}
