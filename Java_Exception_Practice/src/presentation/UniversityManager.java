package presentation;

import business.*;
import entity.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UniversityManager {
    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<CourseRegistration> registrations = new ArrayList<>();
    private List<ClassRoom> classrooms = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();

    private CourseManager courseManager;
    private TeacherManager teacherManager;
    private StudentManager studentManager;
    private RegistrationManager registrationManager;
    private ClassRoomManager classRoomManager;

    public UniversityManager() {
        courseManager = new CourseManager(courses, classrooms);
        teacherManager = new TeacherManager(teachers, classrooms);
        studentManager = new StudentManager(students, registrations);
        registrationManager = new RegistrationManager(registrations, students, courses);
        classRoomManager = new ClassRoomManager(classrooms, students, teachers, schedules);
    }

    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("************************* UNIVERSITY MENU **********************");
                System.out.println("1. Quản lý khóa học");
                System.out.println("2. Quản lý giao viên");
                System.out.println("3. Quản lý sinh viên");
                System.out.println("4. Đăng ký khóa học");
                System.out.println("5. Quản lý lớp học");
                System.out.println("6. Thống kê");
                System.out.println("7. Thoát");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: manageCourses(scanner); break;
                    case 2: manageTeachers(scanner); break;
                    case 3: manageStudents(scanner); break;
                    case 4: manageRegistrations(scanner); break;
                    case 5: manageClassrooms(scanner); break;
                    case 6: displayDashboard(scanner); break;
                    case 7: return;
                    default: System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void manageCourses(Scanner scanner) throws Exception {
        while (true) {
            System.out.println("************************* COURSE MENU *************************");
            System.out.println("1. Danh sách khóa học");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học");
            System.out.println("5. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: courseManager.displayCourses(); break;
                case 2: courseManager.addCourse(scanner); break;
                case 3: courseManager.updateCourse(scanner); break;
                case 4: courseManager.deleteCourse(scanner); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void manageTeachers(Scanner scanner) throws Exception {
        while (true) {
            System.out.println("************************* TEACHER MENU *************************");
            System.out.println("1. Danh sách giảng viên");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: teacherManager.displayTeachers(); break;
                case 2: teacherManager.addTeacher(scanner); break;
                case 3: teacherManager.updateTeacher(scanner); break;
                case 4: teacherManager.deleteTeacher(scanner); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void manageStudents(Scanner scanner) throws Exception {
        while (true) {
            System.out.println("************************* STUDENT MENU *************************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: studentManager.displayStudents(); break;
                case 2: studentManager.addStudent(scanner); break;
                case 3: studentManager.updateStudent(scanner); break;
                case 4: studentManager.deleteStudent(scanner); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void manageRegistrations(Scanner scanner) throws Exception {
        while (true) {
            System.out.println("******************* COURSE REGISTRATION MENU *****************");
            System.out.println("1. Đăng ký khóa học");
            System.out.println("2. Hủy đăng ký");
            System.out.println("3. Duyệt đăng ký");
            System.out.println("4. Xem danh sách đăng ký");
            System.out.println("5. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: registrationManager.registerCourse(scanner); break;
                case 2: registrationManager.cancelRegistration(scanner); break;
                case 3: registrationManager.approveRegistration(scanner); break;
                case 4: registrationManager.displayRegistrationsByCourse(scanner); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void manageClassrooms(Scanner scanner) throws Exception {
        while (true) {
            System.out.println("********************** CLASS ROOM MENU **********************");
            System.out.println("1. Danh sách lớp học");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên");
            System.out.println("6. Thêm sinh viên");
            System.out.println("7. Tạo lịch học");
            System.out.println("8. Cập nhật trạng thái");
            System.out.println("9. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: classRoomManager.displayClassrooms(); break;
                case 2: classRoomManager.addClassroom(scanner); break;
                case 3: classRoomManager.updateClassroom(scanner); break;
                case 4: classRoomManager.deleteClassroom(scanner); break;
                case 5: classRoomManager.assignTeacher(scanner); break;
                case 6: classRoomManager.addStudent(scanner); break;
                case 7: classRoomManager.createSchedule(scanner); break;
                case 8: classRoomManager.updateStatus(scanner); break;
                case 9: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void displayDashboard(Scanner scanner) {
        while (true) {
            System.out.println("************************** DASHBOARD ***********************");
            System.out.println("1. Thống kê số lượng");
            System.out.println("2. Top 3 khóa học đông SV");
            System.out.println("3. Top 3 lớp học đông SV");
            System.out.println("4. Top 3 GV dạy nhiều SV");
            System.out.println("5. Top 3 SV đăng ký nhiều");
            System.out.println("6. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Students: " + students.size());
                    System.out.println("Teachers: " + teachers.size());
                    System.out.println("Courses: " + courses.size());
                    System.out.println("Classrooms: " + classrooms.size());
                    break;
                case 2:
                    registrations.stream()
                            .collect(Collectors.groupingBy(CourseRegistration::getCourseId, Collectors.counting()))
                            .entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .limit(3)
                            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
                    break;
                case 3:
                    classrooms.stream()
                            .sorted(Comparator.comparingInt(c -> c.getListStudents().size()))
                            .limit(3)
                            .forEach(c -> System.out.println(c.getClassRoomName() + ": " + c.getListStudents().size()));
                    break;
                case 4:
                    classrooms.stream()
                            .collect(Collectors.groupingBy(ClassRoom::getTeacherId,
                                    Collectors.summingInt(c -> c.getListStudents().size())))
                            .entrySet().stream()
                            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                            .limit(3)
                            .forEach(e -> System.out.println("Teacher " + e.getKey() + ": " + e.getValue()));
                    break;
                case 5:
                    registrations.stream()
                            .collect(Collectors.groupingBy(CourseRegistration::getStudentId, Collectors.counting()))
                            .entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .limit(3)
                            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
                    break;
                case 6: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        new UniversityManager().displayMainMenu();
    }
}