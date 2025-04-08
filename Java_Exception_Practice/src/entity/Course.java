package entity;

import java.util.Scanner;

public class Course implements IApp {
    private String courseId;
    private String courseName;
    private boolean status;

    public Course() {}

    @Override
    public void inputData(Scanner scanner) throws Exception {
        System.out.print("Enter course ID (Cxxxx): ");
        String id = scanner.nextLine();
        if (!id.matches("^C[A-Za-z0-9]{4}$")) {
            throw new Exception("Invalid course ID format!");
        }
        this.courseId = id;

        System.out.print("Enter course name (20-100 chars): ");
        String name = scanner.nextLine();
        if (name.length() < 20 || name.length() > 100) {
            throw new Exception("Course name must be 20-100 characters!");
        }
        this.courseName = name;

        System.out.print("Enter status (true/false): ");
        String statusStr = scanner.nextLine();
        if (!statusStr.equalsIgnoreCase("true") && !statusStr.equalsIgnoreCase("false")) {
            throw new Exception("Status must be true or false!");
        }
        this.status = Boolean.parseBoolean(statusStr);
    }

    // Getters and setters
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public boolean getStatus() { return status; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "Course{courseId='" + courseId + "', courseName='" + courseName + "', status=" + status + "}";
    }
}