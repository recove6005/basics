//package com.example.seq.config;
//
//import com.example.seq.service.CustomUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class ProjectConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .successHandler(new CustomSuccessHandler())
//                .failureHandler(new CustomFailedHandler())
//                .defaultSuccessUrl("/main", true)
//        .and()
//                .httpBasic(c -> {
//            c.realmName("test");
//            c.authenticationEntryPoint(new CustomEntryPoint());
//        });
//
////        http.authorizeRequests()
////                .anyRequest().hasAnyAuthority("READ");
//
//        http.authorizeRequests()
//                .mvcMatchers("/main").authenticated() // james tom
//                .mvcMatchers("/logins").hasRole("USER") // /logins은 USER만 접근 가능 james
//                .mvcMatchers("/board").hasAuthority("WRITE") // tom
//                .mvcMatchers("/error").permitAll() //  james tom 로그인 없이 가능
//                .anyRequest().denyAll();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var manager = new InMemoryUserDetailsManager();
//
////        var userDetailsService = new InMemoryUserDetailsManager();
////        var user = User
////                .withUsername("john") // (필수)
////                .password("123") // 비밀번호(필수)
////                .authorities("READ") // read 권한(필수)
////                .build();
////        userDetailsService.createUser(user);
//        UserDetails james = User.withUsername("james")
//                .password(passwordEncoder().encode("456"))
//                .roles("USER")
//                .authorities("READ", "WRITE")
//                .build();
//
//        UserDetails tom = User.withUsername("tom")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN")
//                .authorities("WRITE")
//                .build();
//
//        manager.createUser(james);
//        manager.createUser(tom);
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
//    }
//}