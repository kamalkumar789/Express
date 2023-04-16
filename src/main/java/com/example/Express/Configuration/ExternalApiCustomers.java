package com.example.Express.Configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties("external")
@Configuration
public class ExternalApiCustomers {

    private Integer myusersport;
    private String myusersapiurl;
    private String myusershost;
}
