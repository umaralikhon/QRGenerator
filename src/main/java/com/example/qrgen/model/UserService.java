package com.example.qrgen.model;

public interface UserService {
    User findById(Long id);
    String save(User user);
}
