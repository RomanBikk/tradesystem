package com.tradesystem;

import com.tradesystem.config.ProductConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ServletComponentScan
@Import({ProductConfig.class})
public class TradeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeSystemApplication.class, args);
    }

}
