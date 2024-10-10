package ru.wenant.repository;

import ru.wenant.model.User;

public interface UserRepository {

    void registerUser(User user);

    boolean existsByEmail(String email);

    User findByEmail(String email);

    void deleteUser(User user);

    void updateUser(User user);

    void updateUser(String newEmail, User user);
}
