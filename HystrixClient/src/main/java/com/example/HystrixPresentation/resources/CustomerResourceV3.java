package com.example.HystrixPresentation.resources;

import com.example.HystrixPresentation.services.CustomerContractServiceV1;
import com.example.HystrixPresentation.services.CustomerInvoicesServiceV1;
import com.example.HystrixPresentation.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/api/customer/v3")
public class CustomerResourceV3 {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerContractServiceV1 contractService;

    @Autowired
    CustomerInvoicesServiceV1 invoiceService;

    @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username) throws InterruptedException {
        return customerService.greeting(username);
    }

    @GetMapping("/{userId}/getCustomerInfo")
    public String getCustomerInfo(@PathVariable("userId") Integer userId) throws InterruptedException {
        return customerService.getCustomerInfo(userId);
    }

    @GetMapping("/{userId}/getCustomerContracts")
    public List<String> getCustomerContracts(@PathVariable("userId") Integer userId) throws InterruptedException {
        return contractService.getCustomerContracts(userId);
    }

    @GetMapping("/{userId}/getCustomerInvoices")
    public List<String> getCustomerInvoices(@PathVariable("userId") Integer userId) throws InterruptedException {
        return invoiceService.getCustomerInvoices(userId);
    }
}
