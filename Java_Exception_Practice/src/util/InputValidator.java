package util;

import java.util.List;
import entity.*;

public class InputValidator {
    public static void checkDuplicateCourseId(String courseId, List<Course> courses) throws Exception {
        if (courses.stream().anyMatch(c -> c.getCourseId().equals(courseId))) {
            throw new Exception("Course ID already exists!");
        }
    }

    public static void checkDuplicateCourseName(String courseName, List<Course> courses) throws Exception {
        if (courses.stream().anyMatch(c -> c.getCourseName().equals(courseName))) {
            throw new Exception("Course name already exists!");
        }
    }

    public static void checkDuplicatePhone(String phone, List<? extends Person> persons) throws Exception {
        if (persons.stream().anyMatch(p -> p.getPhone().equals(phone))) {
            throw new Exception("Phone number already exists!");
        }
    }

    public static void checkDuplicateEmail(String email, List<? extends Person> persons) throws Exception {
        if (persons.stream().anyMatch(p -> p.getEmail().equals(email))) {
            throw new Exception("Email already exists!");
        }
    }

    public static void checkDuplicateStudentId(String studentId, List<Student> students) throws Exception {
        if (students.stream().anyMatch(s -> s.getStudentId().equals(studentId))) {
            throw new Exception("Student ID already exists!");
        }
    }

    public static void checkDuplicateClassRoomName(String name, List<ClassRoom> classrooms) throws Exception {
        if (classrooms.stream().anyMatch(c -> c.getClassRoomName().equals(name))) {
            throw new Exception("Classroom name already exists!");
        }
    }
}