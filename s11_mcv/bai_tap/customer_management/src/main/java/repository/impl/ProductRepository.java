package repository.impl;

import model.Product;
import repository.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductService {

    private static List<Product> productList = new ArrayList<>();
        static{
            productList.add(new Product(1,"Banh",2000.0,"con","kinhdo"));
            productList.add(new Product(2,"Keo",2000.0,"het","kinhdo"));
            productList.add(new Product(3,"BimBim",2000.0,"con","kinhdo"));
            productList.add(new Product(4,"Chuoi",2000.0,"con","kinhdo"));
            productList.add(new Product(5,"Sua",2000.0,"con","kinhdo"));
        }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void create(Object o) {
        productList.add(product);
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
