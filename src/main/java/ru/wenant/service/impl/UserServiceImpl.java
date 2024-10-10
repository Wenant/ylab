package ru.wenant.service.impl;

import ru.wenant.dto.UserDTO;
import ru.wenant.mapper.UserMapper;
import ru.wenant.model.User;
import ru.wenant.repository.UserRepository;
import ru.wenant.repository.impl.UserRepositoryImpl;
import ru.wenant.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        var userEmail = userDTO.getEmail().toLowerCase();

        if(isEmailTaken(userEmail)) {
            throw new IllegalArgumentException("User with this email already exists.");
        } else {
            userDTO.setEmail(userDTO.getEmail().toLowerCase());
            var user = UserMapper.INSTANCE.userDTOToUser(userDTO);
            userRepository.registerUser(user);
            System.out.println("User registered successfully");
        }

    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }


}