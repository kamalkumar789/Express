package com.example.Express.POJOS;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @JsonProperty("Customer")
    private CustomerData customerData;

    @JsonProperty("Products")
    private List<ProductData> productDataList;

}
