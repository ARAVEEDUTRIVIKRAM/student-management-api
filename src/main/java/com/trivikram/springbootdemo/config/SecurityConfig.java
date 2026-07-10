package com.trivikram.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // It tells spring that this class contains configurations, it is like a settings in java.
public class SecurityConfig {

    @Bean // It will Create's objects and manges for us automatically
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/user/register").permitAll()   // Meaning Any body can access this api without need to be authenticated

                        .requestMatchers("/user/login").permitAll()

                        // Any URL Starts with /admin is only accessible to the user with the ADMIN role.
                        .requestMatchers("/admin/**").hasRole("ADMIN")   // "/** -> means everything inside the admin api like create student delete student view student like that ,  2) hasRole("ADMIN")-> A User who Role is setted To ADMIN can only Acess this URL. or API

                        .requestMatchers("/students/**").hasRole("USER")   // hasRole Simply says , A particular APIS is ONLY Accessed to the Particular ROLES
                        .requestMatchers("/students/**").hasRole("USER")   // hasRole Simply says , A particular APIS is ONLY Accessed to the Particular ROLES

                        .anyRequest().authenticated()
                );
        return http.build();  // This says iam done with the authorization Rules you should proceed to create the securityfilterchain


    }
}
