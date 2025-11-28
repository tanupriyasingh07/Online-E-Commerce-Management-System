package com.online.ecommerce.model;

public class Seller extends User {

    public Seller() {
        this.role = "SELLER";
    }

    public Seller(int id, String name, String email, String password) {
        super(id, name, email, password, "SELLER");
    }

    @Override
    public String getDashboardPath() {
        return "/seller-dashboard.jsp";
    }
}
