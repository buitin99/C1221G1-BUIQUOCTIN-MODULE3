package service;
import java.util.List;
import java.util.Map;

public interface ICrud<E> {
    List<E> getList();
    Map<String, String> save(E e);
    E findById(Integer id);
}
