package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

interface IApp {
    void inputData(Scanner scanner);
}

class Customer implements IApp {
    private static int idCounter = 1;
    private int id;
    private String name;
    private Optional<String> email;
    private List<Order> orders;

    public Customer() {
        this.id = idCounter++;
        this.email = Optional.empty();
        this.orders = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Optional<String> getEmail() { return email; }
    public void setEmail(String email) { this.email = Optional.ofNullable(email); }
    public List<Order> getOrders() { return orders; }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên khách hàng: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập email khách hàng (hoặc bỏ trống): ");
        String emailInput = scanner.nextLine();
        if (!emailInput.trim().isEmpty()) {
            this.email = Optional.of(emailInput);
        }
    }

    @Override
    public String toString() {
        return "Mã: " + id + ", Tên: " + name + ", Email: " + email.orElse("Không có email") + ", Tổng đơn: " + orders.size();
    }
}

class Order implements IApp {
    private static int idCounter = 1;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order(Customer customer) {
        this.id = idCounter++;
        this.customer = customer;
        this.orderDate = LocalDate.now();
        this.totalAmount = 0.0;
        this.status = false;
    }

    public int getId() { return id; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tổng tiền đơn hàng: ");
        this.totalAmount = scanner.nextDouble();
        scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Mã đơn: " + id + ", Khách hàng: " + customer.getName() + ", Ngày: " + orderDate + ", Tổng tiền: " + totalAmount + ", Trạng thái: " + (status ? "Đã giao" : "Chưa giao");
    }
}

interface IOrderBusiness {
    void addOrder(Scanner scanner);
    void displayOrders();
    void updateOrderStatus(Scanner scanner);
    List<Order> getOrderOverdue();
    default double getTotalRevenue() {
        return 0.0;
    }
}

class CustomerBusiness {
    private static List<Customer> customers = new ArrayList<>();

    public static void addCustomer(Scanner scanner) {
        Customer customer = new Customer();
        customer.inputData(scanner);
        customers.add(customer);
    }

    public static void displayCustomers() {
        customers.forEach(System.out::println);
    }
}

class OrderBusiness implements IOrderBusiness {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Scanner scanner) {
        System.out.print("Nhập mã khách hàng: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = CustomerBusiness.customers.stream().filter(c -> c.getId() == customerId).findFirst().orElse(null);
        if (customer != null) {
            Order order = new Order(customer);
            order.inputData(scanner);
            orders.add(order);
            customer.getOrders().add(order);
        } else {
            System.out.println("Khách hàng không tồn tại!");
        }
    }

    @Override
    public void displayOrders() {
        orders.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        orders.stream().filter(o -> o.getId() == orderId).findFirst().ifPresent(o -> o.setStatus(true));
    }

    @Override
    public List<Order> getOrderOverdue() {
        return new ArrayList<>();
    }

    @Override
    public double getTotalRevenue() {
        return orders.stream().filter(Order::isStatus).mapToDouble(o -> o.totalAmount).sum();
    }
}

public class ShopManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderBusiness orderBusiness = new OrderBusiness();

    public static void main(String[] args) {
        while (true) {
            System.out.println("*** SHOP MENU ***");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: customerMenu(); break;
                case 2: orderMenu(); break;
                case 3: return;
                default: System.out.println("Chọn sai!");
            }
        }
    }

    private static void customerMenu() {
        while (true) {
            System.out.println("*** CUSTOMER MENU ***");
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) CustomerBusiness.displayCustomers();
            else if (choice == 2) CustomerBusiness.addCustomer(scanner);
            else break;
        }
    }

    private static void orderMenu() {
        while (true) {
            System.out.println("*** ORDER MENU ***");
            System.out.println("1. Danh sách đơn hàng");
            System.out.println("2. Thêm mới đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) orderBusiness.displayOrders();
            else if (choice == 2) orderBusiness.addOrder(scanner);
            else if (choice == 3) orderBusiness.updateOrderStatus(scanner);
            else break;
        }
    }
}
