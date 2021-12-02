package com.example.qrgen;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
public class QrGenApplication {

    public static void main(String[] args) throws WriterException, IOException {
        String data = "Hello World!";
        String path = "{Path}\\QR_Code_Name.jpg";

        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 250,250);
        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
    }
}
