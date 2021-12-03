package com.example.qrgen;

import com.google.zxing.WriterException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class QrGenApplication {

    public static void main(String[] args) throws WriterException, IOException {
        SpringApplication.run(QrGenApplication.class, args);
    }
}
