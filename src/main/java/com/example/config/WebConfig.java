package com.example.config;

import javax.servlet.annotation.MultipartConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableJpaRepositories("com.example.repository")
@ComponentScan("com.example.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/"); //To change body of generated methods, choose Tools | Templates.

    }

    @Bean
    public MessageSource messageSource() {
        
       ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
       messageSource.setBasename("messages");
       return messageSource; 
        
        /**  Working Code using RelodableResourceBundleMessageSource
        * ReloadableResourceBundleMessageSource  messageSource = new ReloadableResourceBundleMessageSource();
        *messageSource.setBasename("/WEB-INF/files/messages");
        *return messageSource; 
        */ }
//   @Bean
//   public CommonsMultipartResolver multipartResolver()
//   {
//       CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//       
//       return commonsMultipartResolver;
//   
//   
//   }
    
    
   @Bean
   public MultipartResolver multipartReslover()
   {
       return new StandardServletMultipartResolver();
   }
    
    
    
    
            

    
        
       
        
    
    
//    
//    }
}
