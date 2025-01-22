package dress_up_studio_be.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type",
                        "Accept", "Jwt-Token", "Authorization", "Origin, Accept",
                        "X-Requested-With", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers")
                .exposedHeaders("Origin", "Content-Type", "Accept", "Jwt-Token",
                        "Authorization", "Access-Control-Allow-Origin",
                        "Access-Control-Allow-Credentials", "File-Name")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowCredentials(true);
    }
}