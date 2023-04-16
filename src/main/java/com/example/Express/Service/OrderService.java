package com.example.Express.Service;

import com.example.Express.Configuration.ExternalApiCustomers;
import com.example.Express.Model.Orders;
import com.example.Express.Model.Product;
import com.example.Express.POJOS.*;
import com.example.Express.Repositories.OrdersRepository;
import com.example.Express.Repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExternalApiCustomers externalApiCustomers;
    public ResponseEntity<Orders> createOrder(OrderRequest orderRequest) throws Exception{

        log.info("Verifying products.....");
        for(ProductData productData: orderRequest.getProductDataList()){
            Product product = productRepository.findProductByIdAndVariant(productData.getId(), productData.getVariantId());
            if(product == null){
                throw new Exception("This product doesn't exits on id and variant: "+productData.getId()+" "+productData.getVariantId());
            }
        }
        log.info("Products are verified.. ");
        ResponseEntity<CustomerValidateResp> response = valiadateCustomer(orderRequest.getCustomerData());
        if(response.getBody().getStatus() == HttpStatus.NOT_FOUND){
            log.info("Customer doesn't exists");
            throw new Exception("Customer doesn't exits");
        }
        log.info("Customer is verfied as well." );
        log.info("Creating order...");
        List<Product> products = new ArrayList<Product>();
        Double sum = 0.0;
        for(ProductData productData: orderRequest.getProductDataList()){
            Product product = productRepository.findProductByIdAndVariant(productData.getId(), productData.getVariantId());
            products.add(product);
            sum = sum + product.getPrice();
        }
        Orders orders = new Orders();
        orders.setProduct(products);
        orders.setPrice(sum);
        orders.setCustomerId(orderRequest.getCustomerData().getId());
        orders.setCustomerCnic(orderRequest.getCustomerData().getIdCardNumber());
        Orders order = ordersRepository.save(orders);
        log.info("Order has been created...");

        return new ResponseEntity<Orders>(order, HttpStatus.CREATED);
    }
    public ResponseEntity<CustomerValidateResp> valiadateCustomer(CustomerData customerData) throws Exception{
        //These externalApiCustomers usershost and all other field will be get from config server
        String apiUrl = externalApiCustomers.getMyusershost()+":"+externalApiCustomers.getMyusersport()+externalApiCustomers.getMyusersapiurl();
        log.info("Verifying customer......");
        log.info("External Api To Validate Customers: "+apiUrl);
        ValidateCustomerRequest validateCustomer = new ValidateCustomerRequest();
        validateCustomer.setCnic(customerData.getIdCardNumber());
        validateCustomer.setId(customerData.getId());
        HttpEntity<ValidateCustomerRequest> httpEntity = new HttpEntity<ValidateCustomerRequest>(validateCustomer);
        ResponseEntity<CustomerValidateResp> response = restTemplate.exchange(apiUrl,HttpMethod.POST,httpEntity, CustomerValidateResp.class);
        return response;
    }

}
