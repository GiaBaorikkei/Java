package business;

import entity.Teacher;
import entity.ClassRoom;
import util.InputValidator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherManager {
    private List<Teacher> teachers;
    private List<ClassRoom> classrooms;
    private int nextId = 1;

    public TeacherManager(List<Teacher> teachers, List<ClassRoom> classrooms) {
        this.teachers = teachers;
        this.classrooms = classrooms;
    }

    public void displayTeachers() {
        Collections.sort(teachers, Comparator.comparingInt(Teacher::getTeacherId).reversed());
        teachers.forEach(t -> System.out.println("ID: " + t.getTeacherId() + " - " + t.getName()));
    }

    public void addTeacher(Scanner scanner) throws Exception {
        Teacher teacher = new Teacher();
        teacher.inputData(scanner);
        InputValidator.checkDuplicatePhone(teacher.getPhone(), teachers);
        InputValidator.checkDuplicateEmail(teacher.getEmail(), teachers);
        teacher.setTeacherId(nextId++);
        teachers.add(teacher);
    }

    public void updateTeacher(Scanner scanner) throws Exception {
        System.out.print("Enter teacher ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Teacher teacher = teachers.stream()
                .filter(t -> t.getTeacherId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("Teacher not found!"));
        teacher.inputData(scanner);
    }

    public void deleteTeacher(Scanner scanner) throws Exception {
        System.out.print("Enter teacher ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (classrooms.stream().anyMatch(c -> c.getTeacherId() == id)) {
            throw new Exception("Cannot delete teacher assigned to classrooms!");
        }
        teachers.removeIf(t -> t.getTeacherId() == id);
    }
}