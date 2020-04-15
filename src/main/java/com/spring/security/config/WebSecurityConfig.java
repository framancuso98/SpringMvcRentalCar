package com.spring.security.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.security.service.CustomUserDetailsService;



@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private UserAuthenticationSuccessHandler successHandler;
  
  
  @Autowired
  private CustomUserDetailsService userDetailsService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/").permitAll()
      //.antMatchers("/auto").hasRole("ADMIN")
      //.antMatchers("/anonymous*").anonymous()
      .antMatchers("/login*").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      //.defaultSuccessUrl("/login", true)
      .successHandler(successHandler)
      //.loginProcessingUrl("/login")
      .failureUrl("/login?error=true")
      //.failureHandler(authenticationFailureHandler());
      .and()
      .logout()
      .logoutUrl("/perform_logout")
      .deleteCookies("JSESSIONID");
      //.logoutSuccessHandler(logoutSuccessHandler());
  }
}
