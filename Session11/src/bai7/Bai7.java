package bai7;

public class Bai7 {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee("Gia Bảo", 30000),
                new PartTimeEmployee("Quỳnh Trang", 25000, 4),
                new FullTimeEmployee("Đăng Thái", 20000),
                new PartTimeEmployee("Tần Hà", 30000, 5)
        };

        for (Employee emp : employees) {
            System.out.println("Nhân viên: " + emp.getName());
            System.out.println("Lương: " + emp.calculateSalary() + "VNĐ");
            System.out.println();
        }
    }
}
