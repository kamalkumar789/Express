package com.example.Express.Configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
//This external will be picked from config server
@ConfigurationProperties("external")
@Configuration
public class ExternalApiCustomers {

    private Integer myusersport;
    private String myusersapiurl;
    private String myusershost;
}
