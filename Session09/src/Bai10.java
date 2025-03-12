import java.util.ArrayList;
import java.util.Scanner;

// Enum giới tính
enum Gender {
    MALE, FEMALE;
}

// Lớp Student
class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    // Constructor không tham số
    public Student() {}

    // Constructor đầy đủ tham số
    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Phương thức nhập dữ liệu từ bàn phím
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.id = scanner.nextInt();
        scanner.nextLine(); // Xử lý ký tự xuống dòng

        System.out.print("Nhập tên sinh viên: ");
        this.name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        this.age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập giới tính (MALE/FEMALE): ");
        String genderInput = scanner.nextLine().toUpperCase();
        this.gender = Gender.valueOf(genderInput);

        System.out.print("Nhập địa chỉ: ");
        this.address = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = scanner.nextLine();
    }

    // Phương thức hiển thị dữ liệu
    public void displayData() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age +
                " | Gender: " + gender + " | Address: " + address + " | Phone: " + phoneNumber);
    }

    // Getter & Setter (nếu cần dùng)
    public int getId() {
        return id;
    }
}

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý xuống dòng

            switch (choice) {
                case 1:
                    showStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Hãy nhập lại.");
            }
        }
    }

    // 1. Hiển thị danh sách sinh viên
    private static void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
            for (Student s : students) {
                s.displayData();
            }
        }
    }

    // 2. Thêm mới sinh viên
    private static void addStudent() {
        System.out.println("\n--- NHẬP THÔNG TIN SINH VIÊN MỚI ---");
        Student newStudent = new Student();
        newStudent.inputData(scanner);
        students.add(newStudent);
        System.out.println("Thêm sinh viên thành công!");
    }

    // 3. Sửa thông tin sinh viên theo ID
    private static void editStudent() {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Nhập thông tin mới cho sinh viên có ID " + id + ":");
                s.inputData(scanner);
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID: " + id);
    }

    // 4. Xóa sinh viên theo ID
    private static void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Xóa sinh viên thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID: " + id);
    }
}
