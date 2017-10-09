package com.db.example.mysqlspringboot.student.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	private static final String USER="USER";
//	private static final String ADMIN="ADMIN";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{

		httpSecurity.authorizeRequests().antMatchers("/students/**").hasRole("USER")
										.antMatchers("/admin/**").hasRole("ADMIN")
										.and()
										.formLogin()  	//.formLogin().loginPage("http://localhost:4200");
										.failureUrl("/login?error").permitAll()
										.and()
										.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		
		authenticationManagerBuilder.jdbcAuthentication()
									.dataSource(dataSource)									
									.usersByUsernameQuery("select username,password, enabled "
														 + "from users "
														 + "where username=?")									
									.authoritiesByUsernameQuery("select username, role "
																+ "from user_roles "
																+ "where username=?");
		
/*
		 authenticationManagerBuilder.inMemoryAuthentication()
										.withUser("user").password("password").roles(USER)
										.and()
										.withUser("admin").password("admin").roles(USER,ADMIN);
*/
	}
}

