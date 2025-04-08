package business;

import entity.ClassRoom;
import entity.Student;
import entity.Teacher;
import entity.Schedule;
import util.InputValidator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClassRoomManager {
    private List<ClassRoom> classrooms;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Schedule> schedules;
    private int nextId = 1;

    public ClassRoomManager(List<ClassRoom> classrooms, List<Student> students,
                            List<Teacher> teachers, List<Schedule> schedules) {
        this.classrooms = classrooms;
        this.students = students;
        this.teachers = teachers;
        this.schedules = schedules;
    }

    public void displayClassrooms() {
        Collections.sort(classrooms, Comparator.comparing(ClassRoom::getCreated).reversed());
        classrooms.forEach(System.out::println);
    }

    public void addClassroom(Scanner scanner) throws Exception {
        ClassRoom classroom = new ClassRoom();
        classroom.inputData(scanner);
        InputValidator.checkDuplicateClassRoomName(classroom.getClassRoomName(), classrooms);
        classroom.setClassroomId(nextId++);
        classrooms.add(classroom);
    }

    public void updateClassroom(Scanner scanner) throws Exception {
        System.out.print("Enter classroom ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        ClassRoom classroom = classrooms.stream()
                .filter(c -> c.getClassroomId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("Classroom not found!"));
        if (classroom.getStatus() == ClassRoom.Status.CLOSE) {
            throw new Exception("Cannot update closed classroom!");
        }
        classroom.inputData(scanner);
    }

    public void deleteClassroom(Scanner scanner) throws Exception {
        System.out.print("Enter classroom ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        ClassRoom classroom = classrooms.stream()
                .filter(c -> c.getClassroomId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("Classroom not found!"));
        if (!classroom.getListStudents().isEmpty() || classroom.getTeacherId() != 0) {
            throw new Exception("Cannot delete classroom with students or teacher!");
        }
        classrooms.remove(classroom);
    }

    public void assignTeacher(Scanner scanner) throws Exception {
        System.out.print("Enter classroom ID: ");
        int classId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter teacher ID: ");
        int teacherId = Integer.parseInt(scanner.nextLine());

        ClassRoom classroom = classrooms.stream()
                .filter(c -> c.getClassroomId() == classId)
                .findFirst()
                .orElseThrow(() -> new Exception("Classroom not found!"));
        if (!teachers.stream().anyMatch(t -> t.getTeacherId() == teacherId)) {
            throw new Exception("Teacher not found!");
        }
        classroom.setTeacherId(teacherId);
    }

    public void addStudent(Scanner scanner) throws Exception {
        System.out.print("Enter classroom ID: ");
        int classId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        ClassRoom classroom = classrooms.stream()
                .filter(c -> c.getClassroomId() == classId)
                .findFirst()
                .orElseThrow(() -> new Exception("Classroom not found!"));
        Student student = students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new Exception("Student not found!"));
        classroom.getListStudents().add(student);
    }

    public void createSchedule(Scanner scanner) throws Exception {
        Schedule schedule = new Schedule();
        schedule.inputData(scanner);
        schedule.setScheduleId(schedules.size() + 1);
        schedules.add(schedule);
    }

    public void updateStatus(Scanner scanner) throws Exception {
        System.out.print("Enter classroom ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        ClassRoom classroom = classrooms.stream()
                .filter(c -> c.getClassroomId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("Classroom not found!"));

        if (classroom.getStatus() == ClassRoom.Status.PENDING) {
            classroom.setStatus(ClassRoom.Status.PROGRESS);
        } else if (classroom.getStatus() == ClassRoom.Status.PROGRESS) {
            classroom.setStatus(ClassRoom.Status.CLOSE);
        }
    }
}