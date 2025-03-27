package ra.entity;

import java.util.Scanner;
import java.time.LocalDate;

class Order implements IApp {
    private static int idCount = 1;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order(Customer customer) {
        this.id = idCount++;
        this.customer = customer;
        this.orderDate = LocalDate.now();
        this.totalAmount = 0.0;
        this.status = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("");
    }
}

