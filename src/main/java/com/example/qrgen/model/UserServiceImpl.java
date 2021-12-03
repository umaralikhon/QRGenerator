package com.example.qrgen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optional = userRepo.findById(id);
        User user = optional.get();
        return user;
    }

    @Override
    public String save(User user){
        userRepo.save(user);
        return user.toString();
    }
}
