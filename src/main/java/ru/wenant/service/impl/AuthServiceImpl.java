package ru.wenant.service.impl;

import ru.wenant.dto.UserDTO;
import ru.wenant.repository.UserRepository;
import ru.wenant.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO authenticateUser(UserDTO userDTO) {
        var userEmail = userDTO.getEmail().toLowerCase();





        return null;
    }
}
