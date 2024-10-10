package ru.wenant.service.impl;

import ru.wenant.dto.UserDTO;
import ru.wenant.mapper.UserMapper;
import ru.wenant.model.User;
import ru.wenant.repository.UserRepository;
import ru.wenant.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        } else {
            return UserMapper.INSTANCE.userToUserDTO(user);
        }

    }
}
