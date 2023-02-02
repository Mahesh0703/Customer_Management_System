package com.cust_mang_syst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableMethodSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser = User
									.withUsername("Json")
									.password(passwordEncoder().encode("Json111"))
									.roles("NORMAL")
									.build();
		
		UserDetails adminUser = User
									.withUsername("Alex")
									.password(passwordEncoder().encode("Alex111"))
									.roles("ADMIN")
									.build();
		
		return new InMemoryUserDetailsManager(normalUser, adminUser);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		String []array = {"/customer/open/*","/customer/user/*/*","/v2/api-docs","/swagger-ui/*"};
		httpSecurity.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/customer/normal")
					.hasRole("NORMAL")
					.requestMatchers("/customer/admin")
					.hasRole("ADMIN")
					.requestMatchers("/customer/private/*")
					.hasRole("ADMIN")
					.requestMatchers(array)
					.permitAll()
					.anyRequest()
					.authenticated()
					.and()
					.formLogin();
		
		return httpSecurity.build();
	}


}
