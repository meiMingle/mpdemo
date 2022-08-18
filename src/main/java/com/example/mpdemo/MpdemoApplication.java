package com.example.mpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiBackground;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@MapperScan("com.example.mpdemo.**.dao")
public class MpdemoApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(MpdemoApplication.class);
        application.setBanner((environment,sourceClass,out)->{
            //\u2588完整方块
            final char FULL_BLACK_CHAR= '█';
            //\u2580上半方块
            final char TOP_BLACK_CHAR= '▀';
            //\u2584下半方块
            final char BOTTOM_BLACK_CHAR= '▄';

            out.println(AnsiOutput.toString(AnsiColor.RED,FULL_BLACK_CHAR,TOP_BLACK_CHAR,BOTTOM_BLACK_CHAR));
        });

        application.run(args);

        //SpringApplication.run(MpdemoApplication.class, args);

    }

}
