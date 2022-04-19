package model;

public class CustomerType {
    private Integer customerID;
    private String nameCustomerType;

    public CustomerType() {
    }

    public CustomerType(Integer customerID, String nameCustomerType) {
        this.customerID = customerID;
        this.nameCustomerType = nameCustomerType;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}
