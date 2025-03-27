package ra.presentation;

import ra.bussiness.StudentBusiness;

import java.util.Scanner;

public class StudentApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ra.bussiness.StudentBusiness studentBusiness = new StudentBusiness();
        int choice;
        do {
            System.out.println("----------------------------Student Menu----------------------------");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("6. Sắp xếp");
            System.out.println("7. Thoát chương trình");
            System.out.println("--------------------------------------------------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    studentBusiness.displayStudents();
                    break;
                case 2:
                    studentBusiness.addStudent(sc);
                    break;
                case 3:
                    studentBusiness.editStudent(sc);
                    break;
                case 4:
                    studentBusiness.deleteStudent(sc);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Thoát chương trình");
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 7);
    }
}