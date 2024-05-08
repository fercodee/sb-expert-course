package github.com.fercodee.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration // All methods of Configuration should be marked with Bean annotation
public class InternacionalizacaoConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // classpath (anypackage) 
        messageSource.setDefaultEncoding("ISO-8859-1"); // portugues brazil
        messageSource.setDefaultLocale(Locale.getDefault()); // Get default local
        return messageSource;
    }

    // LocalValidatorFactoryBean make interpolation with messages.properties
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
// Tip: You can create message_english.properties