package com.online.ecommerce.model;

public class Buyer extends User {

    public Buyer() {
        this.role = "BUYER";
    }

    public Buyer(int id, String name, String email, String password) {
        super(id, name, email, password, "BUYER");
    }

    @Override
    public String getDashboardPath() {
        return "/buyer-dashboard.jsp";
    }
}
