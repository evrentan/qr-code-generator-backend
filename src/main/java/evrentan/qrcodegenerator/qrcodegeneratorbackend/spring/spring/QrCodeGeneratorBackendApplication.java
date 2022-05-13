package evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.spring;

import evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config.BufferedImageHttpConverterConfig;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config.CommonConfig;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config.SwaggerConfig;
import evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {CommonConfig.class
    , WebConfig.class
    , SwaggerConfig.class
    , BufferedImageHttpConverterConfig.class})
public class QrCodeGeneratorBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(QrCodeGeneratorBackendApplication.class, args);
  }

}
