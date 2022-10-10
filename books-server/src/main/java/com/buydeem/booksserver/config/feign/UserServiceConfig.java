package com.buydeem.booksserver.config.feign;

import com.buydeem.booksserver.config.IgnoreResponseWrapperDecoder;
import feign.Logger;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;

public class UserServiceConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public Decoder decoder(){
        return new IgnoreResponseWrapperDecoder();
    }
}
