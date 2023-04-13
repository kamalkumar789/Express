package com.example.Express.POJOS;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {

    @JsonProperty("productId")
    private Integer id;

    @JsonProperty("variantId")
    private String variantId;
}
