package ra.entity;

import java.util.Scanner;

public class Student implements IApp {
    private String studentId;
    private String studentName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status = 1;

    public Student() {}

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public byte getStatus() {
        return status;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nhập mã sinh viên (Ký tự, bắt đầu bằng SV): ");
        this.studentId = sc.nextLine().trim();

        System.out.print("Nhập tên sinh viên: ");
        this.studentName = sc.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        this.birthday = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = sc.nextLine();

        System.out.print("Nhập giới tính (true - Nam, false - Nữ): ");
        this.sex = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Nhập email: ");
        this.email = sc.nextLine();

        System.out.print("Nhập ngành học: ");
        this.major = sc.nextLine();

        System.out.print("Nhập tên lớp: ");
        this.className = sc.nextLine();

        System.out.print("Nhập GPA: ");
        this.gpa = sc.nextFloat();
        sc.nextLine();
    }

    @Override
    public void displayData() {

        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Tên sinh viên: " + studentName);
        System.out.println("Ngày Sinh: " + birthday);
        System.out.println("Giới tính: " + (sex ? "Nam" : "Nữ"));
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("Tên lớp: " + className);
        System.out.println("Trạng thái: " + (status == 1 ? "Đang theo học" : status == 2 ? "Bảo lưu" : "Đã nghỉ học"));
    }
}
