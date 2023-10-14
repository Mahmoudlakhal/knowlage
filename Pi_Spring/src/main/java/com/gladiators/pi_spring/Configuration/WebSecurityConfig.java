package com.gladiators.pi_spring.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable() // Désactiver CSRF pour les appels depuis Angular
                .headers()
                .frameOptions().sameOrigin() // Autoriser l'affichage d'iframe depuis le même domaine
                .and()
                .authorizeRequests()
                // Configuration des autorisations
                .antMatchers("/user/ajouterUser").permitAll()
                .antMatchers("/user/remove-User/{idUser}").permitAll()
                .antMatchers("/user/updateUser/{idUser}").permitAll()
                .antMatchers("/user/GetAllUser").permitAll()
                .antMatchers("/Cours/addCoursAndImage").permitAll()
                .antMatchers("/image/saveImage").permitAll()
                .antMatchers("/video/saveVideo").permitAll()
                .antMatchers("/image/getImage/{id}").permitAll()
                .antMatchers("/video/getVideo/{id}").permitAll()
                .antMatchers("/Cours/addCoursAndImage").permitAll()
                .antMatchers("/TD/addTD").permitAll()
                .antMatchers("/TD/display").permitAll()
                .antMatchers("/Cours/addCours").permitAll()
                .antMatchers("/Cours/display").permitAll()
                .antMatchers("/Cours/displayImage/{coursId}").permitAll()
                .antMatchers("/Cours/{id}").permitAll()
                .antMatchers("/Cours/displayVideo/{coursId}").permitAll()
                .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                .and()
                .httpBasic(); // Utiliser l'authentification basique
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}




