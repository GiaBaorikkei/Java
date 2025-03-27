package bai3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Bảo", "0333345386"),
                new User("Hùng", null),
                new User("Hoàng", "0383911623"),
                new User("Khoa", null)
        );

        users.forEach(User::printInfo);
    }
}
