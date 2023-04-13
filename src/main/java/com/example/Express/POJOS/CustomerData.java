package com.example.Express.POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {

    @JsonProperty("customerId")
    private Integer id;

    @JsonProperty("Cnic")
    private Long idCardNumber;

}
