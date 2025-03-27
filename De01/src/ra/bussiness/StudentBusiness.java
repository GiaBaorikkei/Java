package ra.bussiness;

import ra.entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentBusiness {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Scanner sc) {
        Student student = new Student();
        student.inputData(sc);
        students.add(student);
        System.out.println("Thêm sinh viên thành công!");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            for (Student student : students) {
                student.displayData();
            }
        }
    }

    public void editStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên cần chỉnh sửa: ");
        String studentId = sc.nextLine();
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.inputData(sc);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên");
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String studentId = sc.nextLine();
        students.removeIf(student -> student.getStudentId().equals(studentId));
        System.out.println("Xóa thành công!");
    }
}
