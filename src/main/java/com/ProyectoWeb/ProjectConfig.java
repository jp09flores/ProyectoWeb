package com.ProyectoWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro").setViewName("/registro");
    }

    /* El siguiente método se utiliza para completar la clase no es 
    realmente funcional, la próxima semana se reemplaza con usuarios de BD */
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("Luis")
                .password("{noop}123")
                .roles("USER", "ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("Jose")
                .password("{noop}456")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/registro", "/logout", "/images/**",
                        "/templates/**", "/js/**", "/webjars/**",
                        "/menu/listado", "/contactenos/muestra",
                        "/comentarios/mostrar", "/nosotros/muestra")
                .permitAll()
                .requestMatchers(
                         "/menu/**",
                        "/contactenos/**", "/nosotros/**",
                        "/comentarios/**", "/detallePedido/**")
                .hasRole("ADMIN")
                .requestMatchers(
                        "/pedidos/**", "/perfil/**"
                ).hasAnyRole("ADMIN", "USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}
