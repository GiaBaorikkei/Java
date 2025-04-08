package business;

import entity.Course;
import entity.ClassRoom;
import util.InputValidator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseManager {
    private List<Course> courses;
    private List<ClassRoom> classrooms;

    public CourseManager(List<Course> courses, List<ClassRoom> classrooms) {
        this.courses = courses;
        this.classrooms = classrooms;
    }

    public void displayCourses() {
        Collections.sort(courses, Comparator.comparing(Course::getCourseName));
        courses.forEach(System.out::println);
    }

    public void addCourse(Scanner scanner) throws Exception {
        Course course = new Course();
        course.inputData(scanner);
        InputValidator.checkDuplicateCourseId(course.getCourseId(), courses);
        InputValidator.checkDuplicateCourseName(course.getCourseName(), courses);
        courses.add(course);
    }

    public void updateCourse(Scanner scanner) throws Exception {
        System.out.print("Enter course ID to update: ");
        String courseId = scanner.nextLine();
        Course course = courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new Exception("Course not found!"));
        course.inputData(scanner);
    }

    public void deleteCourse(Scanner scanner) throws Exception {
        System.out.print("Enter course ID to delete: ");
        String courseId = scanner.nextLine();
        if (classrooms.stream().anyMatch(c -> c.getCourseId().equals(courseId))) {
            throw new Exception("Cannot delete course with existing classrooms!");
        }
        courses.removeIf(c -> c.getCourseId().equals(courseId));
    }
}