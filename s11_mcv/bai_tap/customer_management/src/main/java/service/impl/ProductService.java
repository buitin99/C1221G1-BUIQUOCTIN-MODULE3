package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private IProductRepository iProductRepository = (IProductRepository) new ProductRepository();

    @Override
    public List<Product> getListProduct() {
        List<Product> productList = iProductRepository.getList();
        return productList;
    }

    @Override
    public Map<String, String> save(Product product) {
        if(product.getName().equals("")) {
            map.put("name","Tên không được để trống");
        } else if(!product.getName().matches("^[a-zA-Z ]+$")) {
            map.put("name","Tên không hợp lệ");
        }

        if(map.isEmpty()) {
            iProductRepository.create();
        }
        return map;
    }
}
