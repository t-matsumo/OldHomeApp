package homeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import homeapp.bean.ViewHelper;

@Configuration
public class BeanConfig {
  @Bean
  public ViewHelper viewHelper() {
    return new ViewHelper();
  }
}