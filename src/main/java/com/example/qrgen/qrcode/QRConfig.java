package com.example.qrgen.qrcode;

import com.example.qrgen.model.User;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;

public class QRConfig {
    private static String data;
    private static String path;

    public static void generateQR(User user) throws IOException, WriterException {
        data = user.getFirstname() + "\n" + user.getLastname() + "\n" + user.getMail();
        path = "src\\QR_Codes\\qr" + user.getId().toString() + ".jpg";

        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 300, 300);
        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));

    }
}
