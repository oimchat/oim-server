package com.oimchat.server.run.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

/**
 * 
 * Description <br>
 * Date 2020-05-15 09:13:51<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

@Configuration
@Import(AuthenticationConfiguration.class)
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
	private final String adminContextPath;

	public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		successHandler.setDefaultTargetUrl(adminContextPath + "/");

		http.authorizeRequests()
				.antMatchers(adminContextPath + "/assets/**").permitAll()
				.antMatchers(adminContextPath + "/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
				.logout().logoutUrl(adminContextPath + "/logout").and()
				.httpBasic().and()
				.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.ignoringAntMatchers(
						adminContextPath + "/instances",
						adminContextPath + "/actuator/**");
		// @formatter:on
	}
}