package ru.wenant.service.impl;

import ru.wenant.dto.UserDTO;
import ru.wenant.mapper.UserMapper;
import ru.wenant.model.User;
import ru.wenant.repository.UserRepository;
import ru.wenant.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        var userEmail = userDTO.getEmail();
        if (isEmailTaken(userEmail)) {
            throw new IllegalArgumentException("User with this email already exists.");
        } else {
            var user = convertToUser(userDTO);
            userRepository.registerUser(user);
            System.out.println("User registered successfully");
        }

    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        var user = convertToUser(userDTO);
        userRepository.updateUser(user);
    }

    @Override
    public void updateUser(String newEmail, UserDTO userDTO) {
        if (isEmailTaken(newEmail)) {
            throw new IllegalArgumentException("User with this email already exists.");
        } else {
            userRepository.updateUser(newEmail, convertToUser(userDTO));
        }

    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        var user = convertToUser(userDTO);
        userRepository.deleteUser(user);
    }

    private User convertToUser(UserDTO userDTO) {
        return UserMapper.INSTANCE.userDTOToUser(userDTO);
    }


}