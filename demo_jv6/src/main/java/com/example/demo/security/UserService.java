//package com.example.demo.security;
//
//import com.example.demo.entity.Account;
//import com.example.demo.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            Account account = accountRepository.findById(username).get();
//            String password = account.getPassword();
//            String[] roles = account.getAuthorities().stream().map(au -> au.getRole().getId())
//                    .collect(Collectors.toList()).toArray(new String[0]);
//            return User.withUsername(username).password(passwordEncoder.encode(password)).roles(roles).build();
//        } catch (Exception e) {
//            throw new UsernameNotFoundException(username + " not found!");
//        }
//    }
//}
