package com.example.Express.Service;

import com.example.Express.Model.Product;
import com.example.Express.POJOS.CustomerData;
import com.example.Express.POJOS.OrderRequest;
import com.example.Express.POJOS.ProductData;
import com.example.Express.Repositories.OrdersRepository;
import com.example.Express.Repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductRepository productRepository;

//    @Value("${MYUSERS_PORT}")
//    private String portNumber;
//
//    @Value("${MYUSERS_HOST}")
//    private String host;
//
//    @Value("${MYUSERS_APIURL_USER}")
//    private String apiUrl;
    public void createOrder(OrderRequest orderRequest) throws Exception{

        //customer validates using microservices
        //validates list of products
        //validates no of items from google cloud
        //create order

        for(ProductData productData: orderRequest.getProductDataList()){
            Product product = productRepository.findProductByIdAndVariant(productData.getId(), productData.getVariantId());
            if(product == null){
                throw new Exception("This product doesn't exits on id and variant: "+productData.getId()+" "+productData.getVariantId());
            }
        }
        log.info("Products are verified.. ");

    }
    public void valiadateCustomer(CustomerData customerData){


    }
}
