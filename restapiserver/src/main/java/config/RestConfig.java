package config;

import controller.ApiExceptionAdvice;
import controller.AuthController;
import controller.AuthExceptionAdvice;
import controller.InfoController;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.AuthService;

@Configuration
@EnableWebMvc
@ComponentScan({"controller", "service"})
public class RestConfig {

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource ms =
        new ResourceBundleMessageSource();
    ms.setBasenames("message.label");
    ms.setDefaultEncoding("UTF-8");
    return ms;
  }

}
