package miu.edu.cs.cs544.CourseRegistrationSystem.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import miu.edu.cs.cs544.CourseRegistrationSystem.jwt.TokenRequestFilter;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private TokenRequestFilter tokenRequestFilter;
	@Autowired
	private AuthenticationEntryPoint jwtAuthenticationEntryPoint;

	private static final String[] PUBLIC_MATCHERS = {
			"/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**",
			"/api/login",
			"/api/register",
			"/"
	};
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
    	.cors().disable()
    	.authorizeRequests()
    	.antMatchers( PUBLIC_MATCHERS )
		.permitAll()
		.anyRequest()
        .authenticated()
        .and()
    	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	http.addFilterBefore(tokenRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	  @Bean
	  @Override public AuthenticationManager authenticationManagerBean() throws
	  Exception { return super.authenticationManagerBean(); }
	

	
	
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 @Bean
	 public ModelMapper modelMapper() {
	     return new ModelMapper();
	 }
	 
	 
	 
}
