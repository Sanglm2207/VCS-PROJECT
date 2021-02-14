package com.itsol.bankapi.services;

import com.itsol.bankapi.models.User;
import com.itsol.bankapi.security.services.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUser(Long id);

    User createUser(User user, UserDetailsImpl currentUser);

    User editUser(Long id, User user, UserDetailsImpl currentUser);

    void deleteUser(Long id, UserDetailsImpl currentUser);
}
