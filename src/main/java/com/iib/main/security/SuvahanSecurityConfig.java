package com.iib.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SuvahanSecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private UserDetailsService userdetailservice;
	@Autowired
	private SeurityEntryPointHandler authenicatedEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.err.println("Request 1st coming here");
//		String user="iibadmin";
//		
// 
//			
//
//			auth.inMemoryAuthentication()
//	        .withUser(user)
//	        .password(encoder().encode("iibadmin@123"))
//	        .roles("USER");
			
		

			
			auth.inMemoryAuthentication()
			
			
			.withUser(
					User.withUsername("AdminIIB")
					.password(encoder().encode("iibadmin@#@!"))
					//.password("{noop}sanu1234")
					.authorities("admin")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("565667")
					.password(encoder().encode("OIVS25"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("564556")
					.password(encoder().encode("UIVS24"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			
			.withUser(
					User.withUsername("125690")
					.password(encoder().encode("EIVS23"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("125689")
					.password(encoder().encode("GIVS22"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("125678")
					.password(encoder().encode("AIVS21"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("125656")
					.password(encoder().encode("NIVS20"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("125623")
					.password(encoder().encode("KIVS19"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			
			.withUser(
					User.withUsername("125601")
					.password(encoder().encode("LIVS18"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("124590")
					.password(encoder().encode("MIVS17"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("124567")
					.password(encoder().encode("HIVS16"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("124545")
					.password(encoder().encode("SIVS15"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("124512")
					.password(encoder().encode("RIVS14"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("123479")
					.password(encoder().encode("SIVS12"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			
			.withUser(
					User.withUsername("123445")
					.password(encoder().encode("UIVS11"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("123423")
					.password(encoder().encode("FIVS10"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("122334")
					.password(encoder().encode("CIVS09"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("121256")
					.password(encoder().encode("IIVS08"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			
//			////////////////////////////////////////
//			
//			//for ICICI individual user1
			.withUser(
					User.withUsername("121256U1")
					.password(encoder().encode("IIVS08P1"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			//for ICICI individual user2
			.withUser(
					User.withUsername("121256U2")
					.password(encoder().encode("IIVS08A2"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			//for ICICI individual user3
			.withUser(
					User.withUsername("121256U3")
					.password(encoder().encode("IIVS08B3"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			//for ICICI individual user4
			.withUser(
					User.withUsername("121256U4")
					.password(encoder().encode("IIVS08S4"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
//			//for ICICI individual user5
			.withUser(
					User.withUsername("121256U5")
					.password(encoder().encode("IIVS08V5"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("121234")
					.password(encoder().encode("BIVS07"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("120189")
					.password(encoder().encode("TIVS06"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("120167")
					.password(encoder().encode("IIVS05"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("120134")
					.password(encoder().encode("RIVS04"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("120123")
					.password(encoder().encode("RIVS03"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					)
			.withUser(
					User.withUsername("019001")
					.password(encoder().encode("NIVS02"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USER")
					)
			
			.withUser(
					User.withUsername("015689")
					.password(encoder().encode("NIVS01"))
					//.password("{noop}sanu1234")
					.authorities("ROLE_USER")
					//.roles("USERs")
					);
//			
			

	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
        
       http .authorizeRequests().antMatchers("/access/**","/swagger-ui/**")
       .hasAnyAuthority("ROLE_USER")
    //   .antMatchers("/access/**").hasIpAddress("0:0:0:0:0:0:0:1")
    //   .antMatchers("/access/**").hasIpAddress("192.168.0.120")
     //  .hasAnyRole("USER")
       
       .anyRequest()
       .authenticated()
      
       .and()
       .formLogin() 
        .and()
        .httpBasic().authenticationEntryPoint(authenicatedEntryPoint);
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//       
       ////////////////////////////
	

	}
	
	//create BcryptPassencoder
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

	

}
