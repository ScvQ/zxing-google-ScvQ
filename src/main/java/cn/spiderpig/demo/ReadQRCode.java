package cn.spiderpig.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {

    public static void main(String[] args) throws IOException, NotFoundException {

        MultiFormatReader multiFormatReader = new MultiFormatReader();

        File file = new File("g://1.png");

        BufferedImage bufferedImage = ImageIO.read(file);

        BinaryBitmap binaryBitmap = new BinaryBitmap(
                new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

        HashMap hints = new HashMap<>();
        // hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        Result result = multiFormatReader.decode(binaryBitmap, hints);
        
        System.out.println(result.getText());

    }

}
