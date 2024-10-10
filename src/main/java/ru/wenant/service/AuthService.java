package ru.wenant.service;

import ru.wenant.dto.UserDTO;

public interface AuthService {

    UserDTO authenticate(String email, String password);
}
