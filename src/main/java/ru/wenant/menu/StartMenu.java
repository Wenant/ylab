package ru.wenant.menu;

import ru.wenant.dto.UserDTO;
import ru.wenant.in.UserInputReader;
import ru.wenant.repository.UserRepository;
import ru.wenant.repository.impl.UserRepositoryImpl;
import ru.wenant.service.UserService;
import ru.wenant.service.impl.UserServiceImpl;

import java.util.Scanner;

public class StartMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final UserService userService = new UserServiceImpl(userRepository);
    static UserInputReader reader = new UserInputReader(scanner);

    public static void run() {
        while (true) {
            showMainMenu();
            int choice = reader.readInt();
            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }


    private static void showMainMenu() {
        System.out.println("\n Welcome to Habit Tracker!");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void register() {
        System.out.println("\n Registration");
        System.out.print("Enter your email: ");
        String email = reader.readEmail();
        System.out.print("Enter your username: ");
        String username = reader.readString();
        System.out.print("Enter your password: ");
        String password = reader.readString();

        UserDTO user = new UserDTO(email, username, password);
        try {
            userService.registerUser(user);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            register();
        }

    }

    private static void login() {
        System.out.println("\n Login");
        System.out.print("Enter your email: ");
        String email = reader.readEmail();
        System.out.print("Enter your password: ");
        String password = reader.readString();


    }
}
