package com.drrive.DrriveApi.config;

import com.drrive.DrriveApi.rest.UserRepository;
import com.drrive.DrriveApi.security.JwtAuthenticationFilter;
import com.drrive.DrriveApi.security.JwtAuthorizationFilter;
import com.drrive.DrriveApi.service.UserService;
import com.google.inject.internal.util.ImmutableList;
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

@EnableWebSecurity
@Configuration
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
                .mvcMatchers("/login").permitAll()
                .mvcMatchers(HttpMethod.GET,"/car").permitAll()
                .mvcMatchers(HttpMethod.GET,"/address").permitAll()
                .mvcMatchers(HttpMethod.GET,"/company").permitAll()
                .mvcMatchers(HttpMethod.GET,"/damage").permitAll()
                .mvcMatchers(HttpMethod.POST,"/damage").permitAll()
                .mvcMatchers(HttpMethod.GET,"/refueling").permitAll()
                .mvcMatchers(HttpMethod.POST,"/refueling").permitAll()
                .mvcMatchers(HttpMethod.GET,"/services").permitAll()
                .mvcMatchers(HttpMethod.GET,"/photo").permitAll()
                .mvcMatchers(HttpMethod.POST,"/photo").permitAll()
                .mvcMatchers(HttpMethod.GET,"/user").permitAll()
                .mvcMatchers(HttpMethod.GET,"/posts").permitAll()
                .mvcMatchers(HttpMethod.GET,"/planned").permitAll()
                .mvcMatchers(HttpMethod.GET,"/reports").permitAll()
                .mvcMatchers(HttpMethod.POST,"/reports").permitAll()
                .mvcMatchers(HttpMethod.GET,"/insurance").permitAll()
                .mvcMatchers(HttpMethod.GET,"/usersData").permitAll()
                .mvcMatchers(HttpMethod.POST,"/car").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/car").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/address").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/address").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/company").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/company").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/damage").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/refueling").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/services").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/services").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/photo").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/user").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/posts").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/posts").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/planned").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/planned").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/reports").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/insurance").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/insurance").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.POST,"/usersData").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/user").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/usersData").hasRole("ADMIN");
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(ImmutableList.of("*"));
        configuration.setAllowedMethods(ImmutableList.of("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));

        configuration.setAllowCredentials(false);
        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}

