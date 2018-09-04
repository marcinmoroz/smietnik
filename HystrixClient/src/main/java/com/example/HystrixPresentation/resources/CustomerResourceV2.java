package com.example.HystrixPresentation.resources;

import com.example.HystrixPresentation.services.CustomerServiceV2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/api/customer/v2")
public class CustomerResourceV2 {

    @Autowired
    CustomerServiceV2 service;

    @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username) throws InterruptedException {
        return service.greeting(username);
    }

    @GetMapping("/{userId}/getCustomerInfo")
    public String getCustomerInfo(@PathVariable("userId") Integer userId) throws InterruptedException {
        return service.getCustomerInfo(userId);
    }

    @GetMapping("/{userId}/getCustomerContracts")
    public List<String> getCustomerContracts(@PathVariable("userId") Integer userId) throws InterruptedException {
        return service.getCustomerContracts(userId);
    }

    @GetMapping("/{userId}/getCustomerInvoices")
    public List<String> getCustomerInvoices(@PathVariable("userId") Integer userId) throws InterruptedException {
        return service.getCustomerInvoices(userId);
    }
}
