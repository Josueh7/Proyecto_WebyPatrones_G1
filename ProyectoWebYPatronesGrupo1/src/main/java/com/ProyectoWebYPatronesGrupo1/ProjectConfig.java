
package com.ProyectoWebYPatronesGrupo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectConfig implements WebMvcConfigurer  {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }
    
        @Autowired
    private UserDetailsService userDetailsService ;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean  //cambiar las rutas cuando todo este listo
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/Menu","/js/**","/webjars/**")
                        .permitAll()
                .requestMatchers(
                        "/calorias/regCalorias","/calorias/guardar","/calorias/listaCalorias",
                        "/calorias/modificarCalorias/**","/calorias/eliminar/**","/calorias/confirmarEliminar/**",
                        "/peso/regPeso","/peso/guardar","/peso/listaPesos","/peso/modificarPeso/**",
                        "/peso/confirmarEliminar/**","/peso/eliminar/**","/sueno/regSueno", "/sueno/guardar",
                        "/sueno/listaSuenos", "/sueno//modificarSueno/**","/sueno/confirmarEliminar/**","/sueno/eliminar/**",
                        "/usuario/nuevo","/usuario/guardar",
                        "/usuario/modificar/**","/usuario/eliminar/**"                        
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/calorias/regCalorias","/calorias/guardar","/calorias/listaCalorias",
                        "/calorias/modificarCalorias/**","/calorias/eliminar/**","/calorias/confirmarEliminar/**",
                        "/peso/regPeso","/peso/guardar","/peso/listaPesos","/peso/modificarPeso/**",
                        "/peso/confirmarEliminar/**","/peso/eliminar/**","/sueno/regSueno", "/sueno/guardar",
                        "/sueno/listaSuenos", "/sueno//modificarSueno/**","/sueno/confirmarEliminar/**","/sueno/eliminar/**"
                ).hasAnyRole("ADMIN", "USER")                
                )
                .formLogin((form) -> form
                .loginPage("/index").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}
