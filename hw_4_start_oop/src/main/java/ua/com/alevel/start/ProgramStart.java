package ua.com.alevel.start;

import ua.com.alevel.entity.Role;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class ProgramStart {
    private static final BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));
    private static final UserService userService = new UserService();

    // Creating instance of ProgramStart class is useless
    private ProgramStart(){

    }

    public static void run() throws IOException {
        greeting();
        while (true){
            navigate();
            caseLogic();
        }
    }

    private static void greeting() throws IOException {
        System.out.println("Welcome to the homework 4!");
        System.out.println("Topic: Start OOP");
        System.out.print("\nPress Enter to continue...");
        reader.readLine();
    }

    private static void navigate(){
        System.out.println();
        System.out.println("Press 1 to create new user");
        System.out.println("Press 2 to delete user");
        System.out.println("Press 3 to update user");
        System.out.println("Press 4 to find user");
        System.out.println("Press 5 to obtain all users");
        System.out.println("Press 0 to exit");
        System.out.print("\nYour input ==> ");
    }
    private static void caseLogic() throws IOException {
        String choice = reader.readLine();
        System.out.println();

        switch (choice){
            case "1" -> create();
            case "2" -> delete();
            case "3" -> update();
            case "4" -> find();
            case "5" -> getAll();
            case "0" -> {
                reader.close();
                System.exit(0);
            }
            default -> System.out.println("Incorrect input");
        }
    }

    private static void create() throws IOException {
        String id = UUID.randomUUID().toString();
        System.out.print("Input email ==> ");
        String email = reader.readLine();
        System.out.print("Input login ==> ");
        String login = reader.readLine();
        System.out.print("Input password ==> ");
        String password = reader.readLine();
        System.out.print("Input role(owner, admin, client) ==> ");
        Role role = Role.valueOf(reader.readLine().toUpperCase());
        User newUser = new User(id, email, login, password, role);
        userService.add(newUser);
    }

    private static void delete() throws IOException {
        System.out.println("Press 1 to delete by login");
        System.out.println("Press 2 to delete by number");
        System.out.print("Your input ==> ");
        String choice = reader.readLine();
        switch (choice){
            case "1" -> {
                System.out.print("Input login ==> ");
                String login = reader.readLine();
                userService.delete(login);
            }
            case "2" -> {
                System.out.print("Input number ==> ");
                int number = Integer.parseInt(reader.readLine());
                userService.delete(number);
            }
        }
    }

    private static void update() throws IOException {
        System.out.print("Input number of user you want to update ==> ");
        int number = Integer.parseInt(reader.readLine());
        User[] users = userService.getAll();
        if(number <= 0 || number > users.length){
            System.out.println("Incorrect number!");
            return;
        }
        System.out.println("What do you want to change?");
        System.out.println("1. Email");
        System.out.println("2. Login");
        System.out.println("3. Password");
        System.out.print("Your input ==> ");
        String choice = reader.readLine();
        int index = number - 1;
        String id = users[index].id();
        String email = users[index].email();
        String login = users[index].login();
        String password = users[index].password();
        Role role = users[index].role();
        System.out.print("Input new info: ");
       switch (choice){
           case "1" -> email = reader.readLine();
           case "2" -> login = reader.readLine();
           case "3" -> password = reader.readLine();
           default -> System.out.println("Incorrect input");
       }
       User updateUser = new User(id, email, login, password, role);
       users[index] = updateUser;
    }

    private static void find() throws IOException {
        System.out.print("Input login of the user you're looking for ==> ");
        String login = reader.readLine();
        User user = userService.getByLogin(login);
        System.out.println(user);
    }

    private static void getAll() {
        System.out.printf("%18s %15s %15s %6s%n", "email", "login", "password", "role");
        User[] users = userService.getAll();
        for (int i = 0;i < users.length; i++) {
            System.out.println(i + 1 + ". " + users[i]);
        }
    }
}
