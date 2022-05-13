package evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@Configuration
public class BufferedImageHttpConverterConfig {

  @Bean
  public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
    return new BufferedImageHttpMessageConverter();
  }
}
