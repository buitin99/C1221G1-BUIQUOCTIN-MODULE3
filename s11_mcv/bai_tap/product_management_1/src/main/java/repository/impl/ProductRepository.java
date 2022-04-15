package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Banh",2000.0,"Sold out","KinhDo"));
        productList.add(new Product(2,"Keo",1000.0,"stock","HaiYen"));
        productList.add(new Product(3,"Duong",8000.0,"stock","MiaSaiGon"));
        productList.add(new Product(4,"But",5000.0,"Sold out","HongHa"));
        productList.add(new Product(5,"BimBim",4000.0,"stock","Ossi"));
    }
    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }
}
