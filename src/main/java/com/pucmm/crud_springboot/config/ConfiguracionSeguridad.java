package com.pucmm.crud_springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by vacax on 27/09/16.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Value("${query.user-jdbc}")
    private String queryUsuario;
    @Value("${query.rol-jdbc}")
    private String queryRol;

    @Qualifier("seguridadServices")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas para permitir unicamente los usuarios
        http
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/js/**", "/actuator/**").permitAll() //permitiendo llamadas a esa
                // s urls.
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/usuarios/**").hasAnyRole("ADMIN")
                .antMatchers("/realizar-alquiler").hasAnyRole("ADMIN", "USER")
                .antMatchers("/register/**").permitAll()
                .anyRequest().authenticated() //cualquier llamada debe ser validada
                .and()
                .formLogin()
                    .loginPage("/login") //indicando la ruta que estaremos util// izando.
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/")
                    .successHandler(authSuccessHandler)
                .failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina.
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logOutUser")
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
