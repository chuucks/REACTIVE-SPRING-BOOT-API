package com.codesolt.springbootreactive.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	
	//NoPassword encoder just for demo proposes
	//Add BCrypt for Production environments
	@Bean
	public MapReactiveUserDetailsService userDetailsService(){
		List<UserDetails> userDetails = new ArrayList<>();
		
		userDetails.add(User.withDefaultPasswordEncoder()
				.username("admin").password("admin").roles("USER", "ADMIN").build());
		userDetails.add(User.withDefaultPasswordEncoder()
				.username("user").password("user").roles("USER").build());
		return new MapReactiveUserDetailsService(userDetails);
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
		http.authorizeExchange()
			.anyExchange().hasRole("ADMIN")
			.and().httpBasic();
		return http.build();
	}
}
