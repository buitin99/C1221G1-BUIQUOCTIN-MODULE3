package model;

public class Service {
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer peoples;
    private Integer typeId;
    private Integer typeIdService;
    private String standard;
    private String describe;
    private Double areaPool;
    private Integer floor;

    public Service() {
    }

    public Service(Integer id, String name, Integer area, Double cost, Integer peoples, Integer typeId, Integer typeIdService, String standard, String describe, Double areaPool, Integer floor) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.peoples = peoples;
        this.typeId = typeId;
        this.typeIdService = typeIdService;
        this.standard = standard;
        this.describe = describe;
        this.areaPool = areaPool;
        this.floor = floor;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getPeoples() {
        return peoples;
    }

    public void setPeoples(Integer peoples) {
        this.peoples = peoples;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeIdService() {
        return typeIdService;
    }

    public void setTypeIdService(Integer typeIdService) {
        this.typeIdService = typeIdService;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
        this.areaPool = areaPool;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
