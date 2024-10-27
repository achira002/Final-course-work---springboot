package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long id);

    User UpdateUser(Long id, User user);

    void deleteUser(Long id);
}
