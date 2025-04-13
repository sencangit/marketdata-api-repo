package com.finance.marketdata.restservices.dao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.*;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    @Value("${test.user}")
    private String testUser;
    @Value("${test.pwd}")
    private String testPwd;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        return new org.springframework.security.core.userdetails.User(
        		testUser,
        		testPwd,
                Collections.emptyList()
        );
    }
}
