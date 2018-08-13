package com.trinhha.demo.itblog.configuration;

import com.trinhha.demo.itblog.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Inject
    UserDetailServiceImpl userDetailService;

    @Inject
    public void configForLogin(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/registration").permitAll()
                .antMatchers("/api/admin/**").hasAnyAuthority("ADMIN").anyRequest()
                .authenticated()
                .and().csrf().disable()
                .formLogin().loginPage("/api/login")
                .failureUrl("/api/login?error")
                .defaultSuccessUrl("/api/admin/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
                .logoutSuccessUrl("/api/")
                .and().exceptionHandling()
                .accessDeniedPage("/api/access-denied");
    }
}
