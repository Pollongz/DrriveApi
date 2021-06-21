package com.drrive.DrriveApi.config;

import com.drrive.DrriveApi.rest.UserRepository;
import com.drrive.DrriveApi.security.JwtAuthenticationFilter;
import com.drrive.DrriveApi.security.JwtAuthorizationFilter;
import com.drrive.DrriveApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public SecurityConfiguration(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(this.userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.GET,"/car").permitAll()
                .antMatchers(HttpMethod.GET,"/address").permitAll()
                .antMatchers(HttpMethod.GET,"/company").permitAll()
                .antMatchers(HttpMethod.GET,"/damage").permitAll()
                .antMatchers(HttpMethod.POST,"/damage").permitAll()
                .antMatchers(HttpMethod.GET,"/refueling").permitAll()
                .antMatchers(HttpMethod.POST,"/refueling").permitAll()
                .antMatchers(HttpMethod.GET,"/services").permitAll()
                .antMatchers(HttpMethod.GET,"/photo").permitAll()
                .antMatchers(HttpMethod.POST,"/photo").permitAll()
                .antMatchers(HttpMethod.GET,"/user").permitAll()
                .antMatchers(HttpMethod.GET,"/posts").permitAll()
                .antMatchers(HttpMethod.GET,"/planned").permitAll()
                .antMatchers(HttpMethod.GET,"/reports").permitAll()
                .antMatchers(HttpMethod.POST,"/reports").permitAll()
                .antMatchers(HttpMethod.GET,"/insurance").permitAll()
                .antMatchers(HttpMethod.GET,"/usersData").permitAll()
                .antMatchers(HttpMethod.POST,"/car").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/car").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/address").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/address").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/company").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/company").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/damage").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/refueling").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/services").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/services").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/photo").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/user").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/posts").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/posts").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/planned").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/planned").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/reports").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/insurance").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/insurance").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/usersData").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/usersData").hasRole("ADMIN");

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

