package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"controller", "service"})
public class RestConfig {

  private final int MAX_SIZE = 10 * 1024 * 1024;

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource ms =
        new ResourceBundleMessageSource();
    ms.setBasenames("message.label");
    ms.setDefaultEncoding("UTF-8");
    return ms;
  }

  @Bean(name = "multipartResolver")
  public MultipartResolver commonsMultipartResolver() {
    CommonsMultipartResolver cmr = new CommonsMultipartResolver();
    cmr.setMaxUploadSize(MAX_SIZE);
    cmr.setMaxUploadSizePerFile(MAX_SIZE);
    cmr.setMaxInMemorySize(0);
    return cmr;
  }

}
