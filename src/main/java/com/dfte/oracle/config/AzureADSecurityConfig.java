//package com.dfte.oracle.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import com.azure.spring.aad.webapp.AADWebSecurityConfigurerAdapter;
//
//public class AzureADSecurityConfig extends AADWebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		super.configure(http);
//
//		http.authorizeRequests().anyRequest().authenticated().and().oauth2Login().userInfoEndpoint();
//				//.oidcUserService(customADOAuth2UserService);
//
//		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
//				.deleteCookies("JSESSIONID").invalidateHttpSession(true);
//
//		/*
//		 * http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()
//		 * );
//		 */
//
//		http.cors().and().csrf().disable();
//
//	}
//	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList("*"));
//		configuration.setAllowedHeaders(Arrays.asList("*"));
//		configuration.setAllowCredentials(true);
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//
//}
