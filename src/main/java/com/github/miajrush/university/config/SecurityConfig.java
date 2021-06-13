package com.github.miajrush.university.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) {
		web.ignoring()
		   .antMatchers( "/resources/**")
		   .antMatchers("/bootstrap/**")
		   .antMatchers("/jquery/**")
		   .antMatchers("/datatables/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .requestMatchers(new AntPathRequestMatcher("/**", "POST")).hasRole("ADMIN")
		    .antMatchers("/**/**/edit", "/**/new").hasRole("ADMIN")
		    .antMatchers("/**").hasAnyRole("ADMIN", "ANONYMOUS")
		    .antMatchers("/", "/login**", "/error").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/login")
		    .defaultSuccessUrl("/")
		    .usernameParameter("username")
		    .passwordParameter("password")
		    .permitAll()
		    .and()
		    .logout()
		    .logoutUrl("/logout")
		    .logoutSuccessUrl("/")
		    .invalidateHttpSession(true)
		    .and()
		    .csrf()
		    .disable()
		    .sessionManagement()
		    .maximumSessions(1);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
