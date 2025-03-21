import java.util.ArrayList;
import java.util.Iterator;

public class Bai1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Thái Nguyễn Gia Bảo");
        students.add("Trần Thị Quỳnh Trang");
        students.add("Tô Viết Hoàng");
        students.add("Cao Đăng Hoàng");
        students.add("Nguyễn Cảnh Hùng");

        System.out.println("Duyệt bằng vòng lặp for:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        System.out.println("\nDuyệt bằng vòng lặp foreach:");
        for (String student : students) {
            System.out.println(student);
        }

        System.out.println("\nDuyệt bằng Iterator:");
        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
