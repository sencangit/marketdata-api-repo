package com.finance.marketdata.restservices.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.finance.marketdata.restservices.models.Product;
import com.finance.marketdata.restservices.service.CustomUserDetailsService;
import com.finance.marketdata.restservices.service.ProductDaoService;
import com.finance.marketdata.restservices.util.JwtUtil;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest(MarketDataController.class)
public class MarketDataControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductDaoService productService;
    
    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtil jwtUtil;
    
    @MockBean
    private CustomUserDetailsService customerService;
    
    @Test
    @WithMockUser(username = "testuser")
    void shouldReturnProductById() throws Exception {
        Product mockProd = new Product();
        mockProd.setProduct_id(7);
        mockProd.setTickerName("IBM.N");

        when(productService.findById(1)).thenReturn(mockProd);

        mockMvc.perform(get("/v1/products/1"))
                .andExpect(status().isOk())                
                .andExpect(jsonPath("$.ticker_name").value("IBM.N"));
    }
}
