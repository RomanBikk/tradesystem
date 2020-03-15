package com.tradesystem.config;

import com.tradesystem.controller.AuthWebController;
import com.tradesystem.domain.DefaultUserDetailsService;
import com.tradesystem.domain.UserDetailsRepository;
import com.tradesystem.repository.UserDetailsRepositoryAdapter;
import com.tradesystem.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    public AuthConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsRepository userRepository() {
        return new UserDetailsRepositoryAdapter(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
/*                .authorizeRequests().antMatchers("/", "/**").authenticated()
                .and()*/
                //.httpBasic();
                .formLogin()
                    .loginPage("/web/login")
                    .and()
                    .logout()
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/web/logout"))
                    .logoutSuccessUrl("/web/login");
/*                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new DefaultUserDetailsService(userRepository());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Bean
    public AuthWebController authWebController() {
        return new AuthWebController();
    }
}
