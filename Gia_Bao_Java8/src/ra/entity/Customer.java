package ra.entity;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private static int idCount = 1;
    private int id;
    private String name;
    private Optional<String> email;
    private List<Order> orders;

    public Customer() {
        this.id = idCount++;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Optional<String> getEmail() {return email;}
    public void setEmail(Optional<String> email) {this.email = email;}
    public List<Order> getOrders() {return orders;}
    public void setOrders(List<Order> orders) {this.orders = orders;}

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên khách hàng");
        this.name = scanner.nextLine();
        System.out.println("Nhập email khách hàng");
        this.email = Optional.of(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Mã khách hàng: " + id + ", Tên khách hàng: " + name + ", Email: " + email + ", Tổng đơn: " + orders.size();
    }
}