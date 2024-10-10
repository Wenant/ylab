package ru.wenant.service;

import ru.wenant.dto.UserDTO;

public interface AuthService {

    UserDTO authenticateUser(UserDTO userDTO);
}
