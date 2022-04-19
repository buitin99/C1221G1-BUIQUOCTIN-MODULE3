package model;

import java.util.Date;

public class Employee extends Person{
    private Double salary;
    private Integer position_id;
    private Integer education_degree_id;
    private Integer division_id;

    public Employee() {
    }

    public Employee(Integer id, String name, Date dateOfBirth, boolean gender, String phone, String email, String address, String id_card, Double salary, Integer position_id, Integer education_degree_id, Integer division_id) {
        super(id, name, dateOfBirth, gender, phone, email, address, id_card);
        this.salary = salary;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }

    public Integer getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(Integer education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public Integer getDivision_id() {
        return division_id;
    }

    public void setDivision_id(Integer division_id) {
        this.division_id = division_id;
    }
}
