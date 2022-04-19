package model;

import java.util.Date;

public class Customer extends Person{
   private Integer customerTypeId;

    public Customer() {
    }

    public Customer(Integer id, String name, Date dateOfBirth, boolean gender, String phone, String email, String address, String id_card, Integer customerTypeId) {
        super(id, name, dateOfBirth, gender, phone, email, address, id_card);
        this.customerTypeId = customerTypeId;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
