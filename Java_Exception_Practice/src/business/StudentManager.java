package business;

import entity.Student;
import entity.CourseRegistration;
import util.InputValidator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students;
    private List<CourseRegistration> registrations;

    public StudentManager(List<Student> students, List<CourseRegistration> registrations) {
        this.students = students;
        this.registrations = registrations;
    }

    public void displayStudents() {
        Collections.sort(students, Comparator.comparing(Student::getName));
        students.forEach(s -> System.out.println(s.getStudentId() + " - " + s.getName()));
    }

    public void addStudent(Scanner scanner) throws Exception {
        Student student = new Student();
        student.inputData(scanner);
        InputValidator.checkDuplicateStudentId(student.getStudentId(), students);
        InputValidator.checkDuplicatePhone(student.getPhone(), students);
        InputValidator.checkDuplicateEmail(student.getEmail(), students);
        students.add(student);
    }

    public void updateStudent(Scanner scanner) throws Exception {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        Student student = students.stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Student not found!"));
        student.inputData(scanner);
    }

    public void deleteStudent(Scanner scanner) throws Exception {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        if (registrations.stream().anyMatch(r -> r.getStudentId().equals(id))) {
            throw new Exception("Cannot delete student with registrations!");
        }
        students.removeIf(s -> s.getStudentId().equals(id));
    }
}