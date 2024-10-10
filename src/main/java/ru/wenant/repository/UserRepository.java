package ru.wenant.repository;

import ru.wenant.model.User;

public interface UserRepository {

    void registerUser(User user);

    boolean existsByEmail(String email);
}
