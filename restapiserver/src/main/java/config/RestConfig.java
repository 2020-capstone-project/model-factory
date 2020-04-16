package config;

import controller.ApiExceptionAdvice;
import controller.AuthController;
import controller.AuthExceptionAdvice;
import controller.InfoController;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.AuthService;

@Configuration
@EnableWebMvc
public class RestConfig {

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource ms =
        new ResourceBundleMessageSource();
    ms.setBasenames("message.label");
    ms.setDefaultEncoding("UTF-8");
    return ms;
  }

  @Bean
  public ApiExceptionAdvice apiExceptionAdvice() {
    return new ApiExceptionAdvice();
  }

  @Bean
  public AuthExceptionAdvice authExceptionAdvice() {
    return new AuthExceptionAdvice();
  }

  @Bean
  public AuthService authService() {
    return new AuthService();
  }

  @Bean
  public AuthController authController() {
    return new AuthController();
  }

  @Bean
  public InfoController infoController() {
    return new InfoController();
  }

}
