package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CourseRegistration implements IApp {
    private int crid;
    private String studentId;
    private String courseId;
    private LocalDate registrationDate;
    private Status status;

    public enum Status { PENDING, ENROLLED, DROPPED }

    public CourseRegistration() {
        this.registrationDate = LocalDate.now();
        this.status = Status.PENDING;
    }

    @Override
    public void inputData(Scanner scanner) throws Exception {
        System.out.print("Enter student ID: ");
        this.studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        this.courseId = scanner.nextLine();
    }

    // Getters and setters
    public int getCrid() { return crid; }
    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }
    public Status getStatus() { return status; }
    public void setCrid(int crid) { this.crid = crid; }
    public void setStatus(Status status) { this.status = status; }
}