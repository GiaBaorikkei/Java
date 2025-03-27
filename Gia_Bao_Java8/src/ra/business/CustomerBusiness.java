package ra.business;

import ra.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
