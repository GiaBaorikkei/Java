package business;

import entity.CourseRegistration;
import entity.Student;
import entity.Course;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistrationManager {
    private List<CourseRegistration> registrations;
    private List<Student> students;
    private List<Course> courses;
    private int nextCrid = 1;

    public RegistrationManager(List<CourseRegistration> registrations, List<Student> students, List<Course> courses) {
        this.registrations = registrations;
        this.students = students;
        this.courses = courses;
    }

    public void registerCourse(Scanner scanner) throws Exception {
        CourseRegistration reg = new CourseRegistration();
        reg.inputData(scanner);
        if (!students.stream().anyMatch(s -> s.getStudentId().equals(reg.getStudentId()))) {
            throw new Exception("Student not found!");
        }
        if (!courses.stream().anyMatch(c -> c.getCourseId().equals(reg.getCourseId()))) {
            throw new Exception("Course not found!");
        }
        reg.setCrid(nextCrid++);
        registrations.add(reg);
    }

    public void cancelRegistration(Scanner scanner) throws Exception {
        System.out.print("Enter registration ID to cancel: ");
        int crid = Integer.parseInt(scanner.nextLine());
        CourseRegistration reg = registrations.stream()
                .filter(r -> r.getCrid() == crid)
                .findFirst()
                .orElseThrow(() -> new Exception("Registration not found!"));
        if (reg.getStatus() != CourseRegistration.Status.PENDING) {
            throw new Exception("Can only cancel PENDING registrations!");
        }
        reg.setStatus(CourseRegistration.Status.DROPPED);
    }

    public void approveRegistration(Scanner scanner) throws Exception {
        System.out.print("Enter registration ID to approve: ");
        int crid = Integer.parseInt(scanner.nextLine());
        CourseRegistration reg = registrations.stream()
                .filter(r -> r.getCrid() == crid)
                .findFirst()
                .orElseThrow(() -> new Exception("Registration not found!"));
        if (reg.getStatus() != CourseRegistration.Status.PENDING) {
            throw new Exception("Can only approve PENDING registrations!");
        }
        reg.setStatus(CourseRegistration.Status.ENROLLED);
    }

    public void displayRegistrationsByCourse(Scanner scanner) {
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();
        registrations.stream()
                .filter(r -> r.getCourseId().equals(courseId))
                .forEach(System.out::println);
    }
}