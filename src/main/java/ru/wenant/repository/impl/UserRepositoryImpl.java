package ru.wenant.repository.impl;

import ru.wenant.model.User;
import ru.wenant.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users = new HashMap<>();


    @Override
    public void registerUser(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.containsKey(email);
    }

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user.getEmail());
    }

    @Override
    public void updateUser(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public void updateUser(String newEmail, User user) {
        users.remove(user.getEmail());
        user.setEmail(newEmail);
        users.put(newEmail, user);
    }


}
