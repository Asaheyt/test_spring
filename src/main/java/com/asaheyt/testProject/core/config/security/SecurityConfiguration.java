package com.asaheyt.testProject.core.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableWebFluxSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
    return serverHttpSecurity
      .csrf().disable()
      .authorizeExchange()
      .pathMatchers("/api/**").hasRole("USER")
      .pathMatchers("/**").permitAll()
      .and().formLogin()
      .and().httpBasic()
      .and().build();
  }

  @Bean
  public MapReactiveUserDetailsService reactiveUserDetailsService() {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    UserDetails user = User
      .withUsername("user")
      .password(passwordEncoder.encode("password"))
      .roles("USER")
      .build();
    return new MapReactiveUserDetailsService(user);
  }

}
