package com.finance.marketdata.restservices.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SampleEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("root");
         
        System.out.println(encodedPassword);

	}

}
