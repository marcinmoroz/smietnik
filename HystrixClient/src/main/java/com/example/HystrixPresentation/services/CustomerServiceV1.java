package com.example.HystrixPresentation.services;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.HystrixPresentation.Tools.Constants.waitTimeMilliseconds;

@Service
public class CustomerServiceV1 {

    @Autowired
    RestTemplate restTemplate;

    @Value("${customer.contractsUri}")
    private String customerContractsUri;

    public String greeting(String username) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Hello customer %s!", username);
    }


    public String getCustomerInfo(Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Customer info for user - %s - is blablabla", userId);
    }


    public List<String> getCustomerContracts(Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        var contracts = new ArrayList<String>() {{ add("Contract1");add("Contract2");add("Contract3");}};
        return contracts;
    }


    public List<String> getCustomerInvoices(Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        var invoices  =new ArrayList<String>() {{ add("Invoice F1/01/2018");add("Invoice F1/02/2018");add("Invoice F1/02/2018");}};
        return invoices;
    }
}
