package evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config;

import evrentan.qrcodegenerator.qrcodegeneratorbackend.filter.CORSFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityConfig {

  @Bean
  public Filter corsFilter() {
    return new CORSFilter();
  }
}
