package com.example.qrgen.controller;

import com.example.qrgen.model.ApiResponse;
import com.example.qrgen.model.User;
import com.example.qrgen.model.UserService;
import com.example.qrgen.qrcode.QRConfig;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ApiResponse save(@RequestBody User user) {
        ApiResponse response = new ApiResponse();

        try {
            userService.save(user);
            response.setMessage("Success");
            response.setSuccess(true);
        } catch (Exception ex) {
            response.setMessage("Error");
            response.setSuccess(false);
            ex.printStackTrace();
        }
        return null;
    }

    @GetMapping("/qr/{id}")
    public String getQR(@PathVariable Long id) throws IOException, WriterException {
        try {
            QRConfig.generateQR(userService.findById(id));
            return "QR saved";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "null";
    }
}
