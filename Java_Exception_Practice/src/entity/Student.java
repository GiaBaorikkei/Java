package entity;

import java.util.Scanner;

public class Student extends Person implements IApp {
    private String studentId;
    private double gpa;

    @Override
    public void inputData(Scanner scanner) throws Exception {
        System.out.print("Enter student ID (SVxxx): ");
        String id = scanner.nextLine();
        if (!id.matches("^SV[A-Za-z0-9]{3}$")) {
            throw new Exception("Invalid student ID format!");
        }
        this.studentId = id;

        System.out.print("Enter name (max 150 chars): ");
        this.name = scanner.nextLine();
        if (name.isEmpty() || name.length() > 150) {
            throw new Exception("Invalid name!");
        }

        System.out.print("Enter age (>=18): ");
        this.age = Integer.parseInt(scanner.nextLine());
        if (age < 18) {
            throw new Exception("Age must be >= 18!");
        }

        System.out.print("Enter address: ");
        this.address = scanner.nextLine();
        if (address.isEmpty()) {
            throw new Exception("Address cannot be empty!");
        }

        System.out.print("Enter phone (VN format): ");
        this.phone = scanner.nextLine();
        if (!phone.matches("^(03|05|07|08|09)[0-9]{8}$")) {
            throw new Exception("Invalid phone number!");
        }

        System.out.print("Enter email: ");
        this.email = scanner.nextLine();
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Invalid email format!");
        }

        System.out.print("Enter sex (MALE/FEMALE/OTHER): ");
        this.sex = Sex.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter GPA: ");
        this.gpa = Double.parseDouble(scanner.nextLine());
    }

    // Getters
    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }
}