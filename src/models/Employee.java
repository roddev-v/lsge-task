package models;

import utils.EmployeeRank;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private String address;
    private EmployeeRank rank;
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeRank getRank() {
        return rank;
    }

    public void setRank(EmployeeRank rank) {
        this.rank = rank;
    }

}
