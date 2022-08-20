package com.example.mpdemo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiBackground;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.EnumMap;
import java.util.Map;

@SpringBootApplication
@EnableTransactionManagement
//@MapperScan("com.example.mpdemo.**.dao")
public class MpdemoApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(MpdemoApplication.class);
        application.setBanner((environment, sourceClass, out) -> {
            String myCodeText = "这是一段测试QR-CODE的文字█▀▄";
            Map<EncodeHintType, Object> crunchifyHintType = new EnumMap<>(EncodeHintType.class);
            crunchifyHintType.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            // Now with version 3.4.1 you could change margin (white border size)
            crunchifyHintType.put(EncodeHintType.MARGIN, 1); /* default = 4 */
            Object put = crunchifyHintType.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
            QRCodeWriter mYQRCodeWriter = new QRCodeWriter(); // throws com.google.zxing.WriterException
            BitMatrix crunchifyBitMatrix = null;
            try {
                crunchifyBitMatrix = mYQRCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, 0,
                        0, crunchifyHintType);
            } catch (WriterException e) {
                out.println("自定义banner加载失败");
                return;
            }
            int width = crunchifyBitMatrix.getWidth();
            int height = crunchifyBitMatrix.getHeight();
            StringBuilder result = new StringBuilder(height * (width + 1));
            for (int i = 0; i <= height; i += 2) {
                for (int j = 0; j < width; j++) {
                    boolean tp = crunchifyBitMatrix.get(i, j);
                    boolean bt = i + 1 >= height || crunchifyBitMatrix.get(i + 1, j);
                    if (tp && bt) {
                        result.append(' ');//'\u0020'
                    } else if (tp) {
                        result.append('▄');//'\u2584'
                    } else if (bt) {
                        result.append('▀');//'\u2580'
                    } else {
                        result.append('█');//'\u2588'
                    }

                }
                result.append('\n');
            }

            out.println(AnsiOutput.toString(AnsiColor.RED, result));
        });

        application.run(args);

        //SpringApplication.run(MpdemoApplication.class, args);

    }

}
