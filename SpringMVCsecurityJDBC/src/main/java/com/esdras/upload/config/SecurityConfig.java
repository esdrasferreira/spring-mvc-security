package com.esdras.upload.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/seguranca**").hasAnyRole("ADMIN", "USER", "MANAGER")

				.and().formLogin().loginProcessingUrl("/entrar").defaultSuccessUrl("/seguranca/login")
				.loginPage("/seguranca/index").permitAll().failureUrl("/seguranca/login?error")
				.usernameParameter("usuario").passwordParameter("senha")

				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID")

				.and().rememberMe().rememberMeParameter("chave") // nome do parametro html
				.rememberMeCookieName("chave") // nome do cookie
				.tokenValiditySeconds(60).and().exceptionHandling().accessDeniedPage("/seguranca/negado");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select usuario, senha, ativo from usuarios where usuario=?")
				.authoritiesByUsernameQuery("select usuario, autorizacao from autorizacoes where usuario=?")
				.passwordEncoder(new BCryptPasswordEncoder());

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		User.UserBuilder admin = User.builder().username("admin").password(passwordEncoder.encode("senha"))
				.roles("ADMIN");

		auth.inMemoryAuthentication().withUser(admin);
	}

}
