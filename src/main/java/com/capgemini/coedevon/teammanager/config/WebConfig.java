package com.capgemini.coedevon.teammanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Value("${app.staticweb.source}")
  private String staticWebSource;

  public static String[] STATIC_RESOURCES = new String[] { "/**.js", "/**.html", "/**.map", "/**.css", "/**.png",
  "/**.ico", "/**.jpg", "/assets/**" };

  @Override
  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/**")//
        .allowCredentials(true)//
        .allowedOrigins("*")//
        .allowedMethods("GET", "POST", "PUT", "DELETE");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    String[] resourceLocations = new String[] { this.staticWebSource, this.staticWebSource + "assets/" };

    registry.addResourceHandler(STATIC_RESOURCES)//
        .addResourceLocations(resourceLocations)//
        .setCachePeriod(3600) //
        .resourceChain(false) // 4.1
        .addResolver(new PathResourceResolver()); //4.1
  }
}