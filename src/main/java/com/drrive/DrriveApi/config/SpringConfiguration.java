package com.drrive.DrriveApi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class SpringConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
