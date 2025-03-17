/*
Định nghĩa tính trừu tượng và vai trò trong Java
Tính trừu tượng trong lập trình hướng đối tượng (OOP) là quá trình che giấu các chi tiết triển khai
phức tạp và chỉ hiển thị những thông tin cần thiết cho người dùng. Nó giúp lập trình viên tập trung
vào cách sử dụng một đối tượng thay vì cách nó được thực hiện bên trong. Trong Java, tính trừu tượng
được thực hiện thông qua lớp trừu tượng (abstract class) và giao diện (interface), giúp tạo ra các thiết kế linh hoạt, dễ mở rộng và bảo trì.

Phân tích tính trừu tượng
Tại sao cần tính trừu tượng trong phần mềm phức tạp?
Giúp giảm sự phụ thuộc vào chi tiết triển khai, chỉ quan tâm đến cách sử dụng.
Hỗ trợ khả năng mở rộng và bảo trì dễ dàng hơn.
Giúp tổ chức mã nguồn tốt hơn, tăng tính tái sử dụng.

Sự khác biệt giữa lớp trừu tượng và giao diện trong Java

Tiêu chí	               Lớp trừu tượng (abstract class)	                                   Giao diện (interface)
Mục đích	    Dùng để chia sẻ thuộc tính và phương thức chung cho các lớp con  	Định nghĩa bộ hành vi mà các lớp phải thực hiện
Phương thức	    Có thể có cả phương thức trừu tượng và phương thức có thân	        Chỉ có phương thức trừu tượng (trước Java 8), hỗ trợ phương thức mặc định (default) từ Java 8
Thuộc tính	    Có thể có biến instance, hằng số, và có thể có trạng thái	        Chỉ chứa hằng số (public static final)
Kế thừa     	Một lớp chỉ có thể kế thừa một lớp trừu tượng	                    Một lớp có thể triển khai nhiều giao diện

Liên hệ thực tế
Ví dụ về máy ATM: Khi rút tiền từ máy ATM, bạn chỉ cần nhập mã PIN và số tiền cần rút mà không cần biết máy xử lý yêu cầu như thế nào bên trong. Điều này giống như cách Java sử dụng tính trừu tượng: người dùng chỉ cần biết phương thức để sử dụng, còn chi tiết bên trong được ẩn đi.
Ví dụ về ô tô: Khi lái xe, bạn chỉ cần biết cách điều khiển vô lăng, ga, phanh mà không cần hiểu chi tiết về động cơ hoạt động thế nào. Lớp trừu tượng trong Java cũng hoạt động tương tự, giúp đơn giản hóa cách sử dụng các đối tượng.
*/

public class Bai2 {
}
