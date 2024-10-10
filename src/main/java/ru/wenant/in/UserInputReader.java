package ru.wenant.in;

import lombok.AllArgsConstructor;
import ru.wenant.util.EmailValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

@AllArgsConstructor
public class UserInputReader {
    private final Scanner scanner;


    /**
     * Reads a string from the user.
     *
     * @return The read string.
     */
    public String readString() {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Input cannot be empty.");
            }
        }
        return input;
    }


    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            try {
                num = scanner.nextInt();
                if (isValidInt(num)) {
                    break;
                } else {
                    System.out.println("Please enter a valid integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid format. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return num;
    }


    private boolean isValidInt(long num) {
        return num >= 0 && num <= Integer.MAX_VALUE;
    }

    public String readEmail() {
        Scanner scanner = new Scanner(System.in);
        String email;
        while (true) {
            email = scanner.nextLine();
            if (EmailValidator.isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email. Please try again.");
            }
        }
        return email;
    }
}
