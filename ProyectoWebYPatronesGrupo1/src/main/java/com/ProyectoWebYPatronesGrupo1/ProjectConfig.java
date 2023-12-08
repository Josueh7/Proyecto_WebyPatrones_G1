
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
        registry.addViewController("/login").setViewName("login");
    }
    
        @Autowired
    private UserDetailsService userDetailsService ;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/errores/**",  "/error/***","/error",
                        "/js/**","/webjars/**", "/css/**", "/Usuario")
                        .permitAll()
                .requestMatchers(
                        
                         "/Menu","/usuario", "/usuario/listado","/usuario/modificar/**", "/usuario/guardar", "/usuario/eliminar/**",
                        
                        "/calorias", "/calorias/regCalorias","/calorias/guardar", "/calorias/listaCalorias",
                        "/calorias/modificarCalorias/**","/calorias/confirmarEliminar/**", "/calorias/eliminar/**",
                        
                       "/cicloMenstrual", "/cicloMenstrual/regCiclo","/cicloMenstrual/guardar", "/cicloMenstrual/listaCalorias",
                      "/cicloMenstrual/modificarCiclo/**","/cicloMenstrual/confirmarEliminar/**", "/cicloMenstrual/eliminar/**",
                        
                        "/sueno", "/sueno/regSueno","/sueno/guardar", "/sueno/listaSuenos",
                        "/sueno/modificarSueno/**","/sueno/confirmarEliminar/**", "/sueno/eliminar/**",
                        
                        "/hidratacion", "/hidratacion/regHidratacion","/hidratacion/guardar", "/hidratacion/listaHidratacion",
                        "/hidratacion/modificarRegistro/**","/hidratacion/confirmarEliminar/**", "/hidratacion/eliminar/**",
                        
                        "/peso", "/peso/regPeso","/peso/guardar", "/peso/listaPesos",
                        "/peso/modificarPeso/**","/peso/confirmarEliminar/**", "/peso/eliminar/**",
                        
                        "/Suplementos", "/Suplementos/regSuplementos","/Suplementos/guardar", "/Suplementos/listadoSuplementos",
                        "/Suplementos/modificarSuplementos/**","/Suplementos/confirmarEliminar/**", "/Suplementos/eliminar/**"
                ).hasAnyRole("USER","ADMIN")                 
                )
                .formLogin(
                        (form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll()
                );
        return http.build();
    }
}

    
    

