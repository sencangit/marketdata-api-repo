package com.finance.marketdata.restservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.finance.marketdata.restservices.models.User;
import com.finance.marketdata.restservices.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {


	@Autowired
    AuthenticationManager authenticationManager;
	/*
	 * @Autowired UserRepository userRepository;
	 */
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    JwtUtil jwtUtils;
    @PostMapping("/getToken")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.username(),
                        user.password()
                )
        );
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }


}
