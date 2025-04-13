package com.finance.marketdata.restservices.util;

import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SampleEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("testpass");
         
        System.out.println(encodedPassword);
        
        String originalInput = "sql_Root";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        
        System.out.println(encodedString);
        
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        
        System.out.println(decodedString);

	}

}
