package ru.wenant.menu;

import ru.wenant.dto.UserDTO;

public class UserMenu {
    public void showMenu(UserDTO user) {

        System.out.println("\n Welcome, " + user.getName() + "!");
    }
}
