package ru.wenant.service;

import ru.wenant.dto.UserDTO;

public interface UserService {

    void registerUser(UserDTO userDTO);

    boolean isEmailTaken(String email);



}
