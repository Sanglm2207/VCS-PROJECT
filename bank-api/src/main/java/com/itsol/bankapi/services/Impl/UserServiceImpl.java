package com.itsol.bankapi.services.Impl;

import com.itsol.bankapi.models.User;
import com.itsol.bankapi.repository.UserRepository;
import com.itsol.bankapi.security.services.UserDetailsImpl;
import com.itsol.bankapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user, UserDetailsImpl currentUser) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(Long id, User user, UserDetailsImpl currentUser) {
        return null;
    }

    @Override
    public void deleteUser(Long id, UserDetailsImpl currentUser) {

    }
}
