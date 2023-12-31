//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class AuthConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserService userService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable();
//        http.authorizeRequests()
//                .antMatchers("/order/**").authenticated()
//                .antMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
//                .antMatchers("/rest/authorities").hasRole("DIRE")
//                .antMatchers("/static/**").hasAnyRole("STAF", "DIRE")
//                .antMatchers("/**").permitAll()
//                .anyRequest().permitAll();
//
////		http.httpBasic();
//
//        http.formLogin().loginPage("/security/login/form").loginProcessingUrl("/security/login")
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/security/login/error");
//
////        http.rememberMe().tokenValiditySeconds(86400);
//
//        http.exceptionHandling().accessDeniedPage("/security/unauthoried");
//
//        http.logout().logoutUrl("/security/logoff").logoutSuccessUrl("/security/logoff/success");
//    }
//}
