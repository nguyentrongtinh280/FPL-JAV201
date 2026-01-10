package poly.com.lab1;

import dao.UserManager;
import entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        User user = new User();
        user.setFullname("Nguyen Minh Tai");
        user.setPassword("123");
        user.setEmail("Tai1@fpt.edu.vn");
        user.setAdmin(false);

        //userManager.create(user);

        //userManager.update(user);

        userManager.findAll().forEach(System.out::println);

        //userManager.deleteById("00000");

        //System.out.println(userManager.findById("U0016"));


        //Bai 3
//        List<User> users = userManager.findByEmail();
//        for (User u : users) {
//            System.out.println("Name: " + u.getFullname() + " | Email: " + u.getEmail());
//        }


        //Bai 4
//        int number = 2;
//        int size = 5;
//        List<User> users = userManager.Page(number, size);
//        for (User u : users) {
//            System.out.println("Id: " + u.getId()
//            + " | Fullname: " + u.getFullname()
//            + " | Email: " + u.getEmail());
//        }


    }
}
