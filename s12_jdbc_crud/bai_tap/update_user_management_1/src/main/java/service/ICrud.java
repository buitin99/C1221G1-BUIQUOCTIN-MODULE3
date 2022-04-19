package service;

import java.util.List;

public interface ICrud<E> {
    List<E> search(String country);
}
