package com.goals.api.service;

import com.goals.api.model.User;
import com.goals.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository  userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No user matches the provided id"));
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User update(Integer id, User entity) {
        return null;
    }

    @Override
    public User delete(Integer id) {
        return null;
    }
}
