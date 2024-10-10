package ru.wenant.service;

import ru.wenant.dto.UserDTO;

public interface UserService {

    void registerUser(UserDTO userDTO);

    boolean isEmailTaken(String email);

    void updateUser(UserDTO userDTO);

    void updateUser(String newEmail, UserDTO userDTO);

    void deleteUser(UserDTO userDTO);


}
