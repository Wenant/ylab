package ru.wenant.menu;

import ru.wenant.dto.UserDTO;
import ru.wenant.in.UserInputReader;
import ru.wenant.service.UserService;

public class UserMenu {
    private final UserInputReader reader;
    private final UserService userService;
    boolean loggedIn = true;

    public UserMenu(UserInputReader reader, UserService userService) {
        this.reader = reader;
        this.userService = userService;
    }

    public void showMenu(UserDTO user) {


        while (loggedIn) {
            System.out.println("\n Hello " + user.getName() + "!");
            System.out.println("User Menu:");
            System.out.println("1. Edit profile");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            int choice = reader.readInt();

            switch (choice) {
                case 1 -> editProfile(user);
                case 2 -> todo(user);
                case 3 -> todo(user);
                case 4 -> todo(user);
                case 5 -> todo(user);
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }

    }

    private void todo(UserDTO user) {

        System.out.println("\n Welcome, " + user.getName() + "!");
    }

    private void editProfile(UserDTO user) {
        System.out.println("\n Edit profile:");
        System.out.println("1. Change name");
        System.out.println("2. Change password");
        System.out.println("3. Change email");
        System.out.println("4. Delete account");
        System.out.println("5. Back");

        System.out.print("Enter your choice: ");
        int choice = reader.readInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter new name: ");
                String newName = reader.readString();
                user.setName(newName);
                userService.updateUser(user);
            }
            case 2 -> {
                System.out.print("Enter new password: ");
                String newPassword = reader.readString();
                user.setPassword(newPassword);
                userService.updateUser(user);
            }
            case 3 -> {
                System.out.print("Enter new email: ");
                String newEmail = reader.readEmail();
                try {
                    userService.updateUser(newEmail, user);
                    System.out.println("Email updated successfully.");
                    user.setEmail(newEmail);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            case 4 -> {
                System.out.print("Are you sure you want to delete your account? (yes/no): ");
                String confirmation = reader.readString().toLowerCase();

                if (confirmation.equals("yes")) {
                    System.out.println("Deleting account...");
                    userService.deleteUser(user);
                    System.out.println("Account deleted. Logging out...");
                    loggedIn = false;
                } else {
                    System.out.println("Account deletion cancelled.");
                }
            }
            case 5 -> {
                showMenu(user);
            }
            default -> System.out.println("Invalid choice");
        }


    }
}
