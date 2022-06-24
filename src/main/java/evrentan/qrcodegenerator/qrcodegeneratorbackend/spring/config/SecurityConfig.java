package evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config;

import evrentan.qrcodegenerator.qrcodegeneratorbackend.filter.CORSFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class SecurityConfig {

  @Bean
  public Filter corsFilter() {
    return new CORSFilter();
  }
}
