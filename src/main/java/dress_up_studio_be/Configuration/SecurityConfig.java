package dress_up_studio_be.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Configure security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorized -> {
            authorized.requestMatchers("/users/**").authenticated(); // Secure /user/** URLs
            authorized.anyRequest().permitAll(); // Allow all other requests
        });
        return httpSecurity.build();
    }
}
