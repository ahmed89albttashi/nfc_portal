package com.nfc.portal.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
//@ComponentScan({"com.nfc.portal"})

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		 http
		 .authorizeRequests()
		 .antMatchers("/resources/**").permitAll()
		 .antMatchers("/error/**").permitAll()
		 .antMatchers("/sec/**").permitAll()
		 
		 .antMatchers("/admin/**").hasRole("ADMIN")
		 .anyRequest().authenticated()
		 .and()
		 .formLogin().loginPage("/sec/login/").defaultSuccessUrl("/").permitAll()
		 .and()
		 .logout().logoutSuccessUrl("/sec/logout/").logoutUrl("/sec/logout/")
		 .permitAll()
		 .and()
		 .exceptionHandling();
		 
		 CharacterEncodingFilter filter = new CharacterEncodingFilter();
	        filter.setEncoding("UTF-8");
	        filter.setForceEncoding(true);
	        http.addFilterBefore(filter,CsrfFilter.class);
	}
 
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}	
	
	@Override
	public void configure(WebSecurity web){
		web.ignoring().antMatchers("/resources/js/**");
	}

	
}
