package com.example.HystrixPresentation.resources;

import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
@RequestMapping(value = "/api/customer/v1")
public class CustomerResourceV1 extends CustomerResource {

    @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username)
    {
        return String.format("Hello customer %s!", username);
    }

    @GetMapping("/{userId}/getCustomerInfo")
    public String getCustomerInfo(@PathVariable("userId") Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Customer info for user - %s - is blablabla", userId);
    }

    @GetMapping("/{userId}/getCustomerContracts")
    public List<String> getCustomerContracts(@PathVariable("userId") Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        var contracts = new ArrayList<String>() {{ add("Contract1");add("Contract2");add("Contract3");}};
        return contracts;
    }

    @GetMapping("/{userId}/getCustomerInvoices")
    public List<String> getCustomerInvoices(@PathVariable("userId") Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        var invoices  =new ArrayList<String>() {{ add("Invoice F1/01/2018");add("Invoice F1/02/2018");add("Invoice F1/02/2018");}};
        return invoices;
    }
}
