package cn.spiderpig.demo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRCode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        int width = 300;
        int height = 300;
        String format = "png";
        String content = "http:/"+"/58.56.110.142/imtt.dd.qq.com/16891/8C3E058EAFBFD4F1EFE0AAA815250716.apk?mkey=593a3aedae285d65&f=3580&c=0&fsname=com.tencent.mobileqq_7.1.0_692.apk&csr=1bbd&p=.apk"
;

        // 解决中文乱码
        content = new String(content.getBytes("UTF-8"), "ISO-8859-1");

        HashMap hints = new HashMap<>();
        // hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.CODABAR.QR_CODE, width, height);
            Path file = new File("G://1.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
