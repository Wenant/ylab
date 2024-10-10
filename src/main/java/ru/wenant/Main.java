package ru.wenant;

import ru.wenant.dto.UserDTO;
import ru.wenant.menu.StartMenu;
import ru.wenant.repository.UserRepository;
import ru.wenant.repository.impl.UserRepositoryImpl;
import ru.wenant.service.UserService;
import ru.wenant.service.impl.UserServiceImpl;
import ru.wenant.util.EmailValidator;

public class Main {
    public static void main(String[] args) {

        StartMenu.run();


//        UserRepository userRepository = new UserRepositoryImpl();
//        UserService userService = new UserServiceImpl(userRepository);
//
//
//
//
//        String email = "email";
//        String email2 = "EMAIL";
//        String email3 = "email@";
//        String email4 = "email@.com";
//        String email5 = "email.com";
//        String email6 = "email@dddd.com";
//        String email7 = "email@DDDD.com";
//
//        System.out.println(EmailValidator.isValidEmail(email));
//        System.out.println(EmailValidator.isValidEmail(email4));
//        System.out.println(EmailValidator.isValidEmail(email6));
//
//
//
//        try {
//            userService.registerUser(new UserDTO("name", email6, "password"));
//            userService.registerUser(new UserDTO("name", email7, "password"));
//            //userService.registerUser(new UserDTO("name", "email", "password"));
//
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}