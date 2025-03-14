/*
    1. TÍnh đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
    Định nghĩa:
        Tính đóng gói là kỹ thuật che giấu dữ liệu của một đối tượng bằng cách giới hạn quyền truy cập vào dữ liệu đó từ bên ngoài lớp.
    Tính đóng gói quan trọng trong lập trình đối tượng vì:
        Bảo vệ dữ liệu
        Kiểm soát quyền truy cập
        Tăng tính bảo trì và dễ dàng thay đổi
        Hỗ trợ ẩn thông tin
     2. làm thế nào để áp dụng tính đóng gói trong java? Giải thích các sử dụng getter và setter
     Cách thực hiện tính đóng gói:
        Khai báo các thuộc tính của lớp ở phạm vi private.
        Cung cấp phương thức getter để lấy dữ liệu.
        Cung cấp phương thức setter để thay đổi dữ liệu (nếu cần).
        Có thể kiểm soát dữ liệu đầu vào trong setter
    Cách sử dụng phương thức getter và setter:
        Getter: Trả về giá trị của một thuộc tính.
        Setter: Thiết lập giá trị mới cho thuộc tính, có thể bổ sung kiểm tra hợp lệ trước khi gán.
*/

// 3. Cho ví dụ về cách sử dụng tính đóng gói trong một lớp có thuộc tính name, age (thuộc tính private),
// và phương thức getter và setter để truy xuất và thay đổi giá trị của chúng.
class Person {
    // Thuộc tính private (không thể truy cập trực tiếp từ bên ngoài)
    private String name;
    private int age;

    // Constructor để khởi tạo giá trị
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter để lấy giá trị của name
    public String getName() {
        return name;
    }

    // Setter để thay đổi giá trị của name
    public void setName(String name) {
        this.name = name;
    }

    // Getter để lấy giá trị của age
    public int getAge() {
        return age;
    }

    // Setter để thay đổi giá trị của age (có kiểm tra hợp lệ)
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Tuổi phải lớn hơn 0!");
        }
    }
}

public class Bai1 {
    public static void main(String[] args) {
        // Tạo đối tượng Person
        Person person = new Person("Thái Nguyễn Gia Bảo", 20);

        // Truy cập dữ liệu bằng phương thức getter
        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person.getAge());

        // Thay đổi giá trị thông qua setter
        person.setName("Trần Thị Quỳnh Trang");
        person.setAge(22);

        // Hiển thị lại thông tin sau khi cập nhật
        System.out.println("Tên mới: " + person.getName());
        System.out.println("Tuổi mới: " + person.getAge());

        // Thử nhập giá trị không hợp lệ
        person.setAge(-5); // Sẽ hiển thị thông báo lỗi
    }
}


