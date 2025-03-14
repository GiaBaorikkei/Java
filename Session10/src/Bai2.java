/*
    1. Tính kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng
    Định nghĩa:
    Kế thừa (Inheritance) là một trong bốn tính chất quan trọng của lập trình hướng đối tượng (OOP), cho phép một lớp (gọi là lớp con) kế thừa các thuộc tính và phương thức của một lớp khác (gọi là lớp cha).
    Kế thừa giúp tạo ra mối quan hệ "is-a" giữa các lớp, nghĩa là một lớp con có thể sử dụng lại các đặc điểm của lớp cha mà không cần viết lại mã.
    Lợi ích:
    Tái sử dụng mã nguồn
    Dễ dàng mở rộng hệ thống
    Dễ bảo trì
    Tổ chức mã tốt hơn
    2. Sự khác biệt giữa kế thừa và bao đóng trong java là gì?
                              	Tính kế thừa (Inheritance)	                                            Tính đóng gói (Encapsulation)
Định nghĩa	    Cho phép một lớp kế thừa các thuộc tính và phương thức của lớp khác.	Giấu thông tin bên trong lớp và chỉ cho phép truy cập thông qua các phương thức cụ thể.
Mục đích	    Tái sử dụng mã, mở rộng chức năng.	                                    Bảo vệ dữ liệu, kiểm soát truy cập.
Cách thực hiện	Dùng từ khóa extends để kế thừa từ lớp cha.	                            Dùng phạm vi truy cập (private, protected, public) và các phương thức getter, setter.
Tính linh hoạt	Giúp tạo mối quan hệ "is-a" giữa các lớp.	                            Giúp bảo mật dữ liệu và tránh truy cập trực tiếp từ bên ngoài.
*/
// 3. Viết một ví dụ ngắn giải thích cách sử dụng từ khoác extends để tạo lớp con kế thừa các thuộc tính và phương thức của lớp cha
// Lớp cha (Superclass)
class Animal {
    String name;

    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dogs extends Animal {
    public void bark() {
        System.out.println(name + " is barking");
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Dogs myDog = new Dogs();
        myDog.name = "Buddy";
        myDog.makeSound();
        myDog.bark();
    }
}
/*
     4. Lợi ích và hạn chế của kế thừa trong Java
     Lợi ích
      Tái sử dụng mã nguồn: Giúp giảm trùng lặp mã bằng cách kế thừa các thuộc tính và phương thức từ lớp cha.
      Dễ mở rộng: Có thể mở rộng lớp cha bằng cách tạo các lớp con có chức năng riêng.
      Tính tổ chức tốt: Mã nguồn dễ đọc hơn do có quan hệ phân cấp rõ ràng giữa các lớp.

     Hạn chế
      Tăng sự phụ thuộc giữa các lớp: Nếu lớp cha thay đổi, các lớp con có thể bị ảnh hưởng.
      Không hỗ trợ đa kế thừa trực tiếp: Java không cho phép một lớp kế thừa nhiều lớp cha (để tránh vấn đề diamond problem).
      Có thể gây khó khăn khi bảo trì: Khi lớp cha quá lớn và phức tạp, việc sửa đổi có thể ảnh hưởng đến nhiều lớp con.
* */