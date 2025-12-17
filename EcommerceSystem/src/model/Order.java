package model;

public class Order {
    private int id;
    private int buyerId;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getBuyerId() { return buyerId; }
    public void setBuyerId(int buyerId) { this.buyerId = buyerId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
