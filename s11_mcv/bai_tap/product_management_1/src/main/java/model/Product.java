package model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String describe;
    private String produce;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String describe, String produce) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.produce = produce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }
}
