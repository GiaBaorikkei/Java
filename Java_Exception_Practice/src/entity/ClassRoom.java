package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp {
    private int classroomId;
    private String classRoomName;
    private String courseId;
    private int teacherId;
    private List<Student> listStudents;
    private LocalDate created;
    private Status status;

    public enum Status { PENDING, PROGRESS, CLOSE }

    public ClassRoom() {
        this.listStudents = new ArrayList<>();
        this.created = LocalDate.now();
        this.status = Status.PENDING;
    }

    public LocalDate getCreated() {
        return created;
    }


    @Override
    public void inputData(Scanner scanner) throws Exception {
        System.out.print("Enter classroom name (15-50 chars): ");
        this.classRoomName = scanner.nextLine();
        if (classRoomName.length() < 15 || classRoomName.length() > 50) {
            throw new Exception("Classroom name must be 15-50 characters!");
        }

        System.out.print("Enter course ID: ");
        this.courseId = scanner.nextLine();
    }

    // Getters and setters
    public int getClassroomId() { return classroomId; }
    public String getClassRoomName() { return classRoomName; }
    public String getCourseId() { return courseId; }
    public int getTeacherId() { return teacherId; }
    public List<Student> getListStudents() { return listStudents; }
    public Status getStatus() { return status; }
    public void setClassroomId(int classroomId) { this.classroomId = classroomId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public void setStatus(Status status) { this.status = status; }
}