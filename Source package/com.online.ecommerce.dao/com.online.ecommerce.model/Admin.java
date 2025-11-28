package com.online.ecommerce.model;

public class Admin extends User {

    public Admin() {
        this.role = "ADMIN";
    }

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password, "ADMIN");
    }

    @Override
    public String getDashboardPath() {
        return "/admin-dashboard.jsp";
    }
}
