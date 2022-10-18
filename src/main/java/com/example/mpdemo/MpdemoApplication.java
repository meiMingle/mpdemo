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
        application.setBanner(new MyBanner());

        application.run(args);

        //SpringApplication.run(MpdemoApplication.class, args);

    }

}
