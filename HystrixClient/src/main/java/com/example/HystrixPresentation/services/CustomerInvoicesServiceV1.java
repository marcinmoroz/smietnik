package com.example.HystrixPresentation.services;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.HystrixPresentation.Tools.Constants.waitTimeMilliseconds;

@Service
@DefaultProperties(groupKey = "CustomerInvoices")
public class CustomerInvoicesServiceV1 {
    @Autowired
    RestTemplate restTemplate;

    @Value("${customer.invoicesUri}")
    private String customerInvoicesUri;

    @HystrixCommand
    public List<String> getCustomerInvoices(Integer userId) throws InterruptedException {
        var invoices = restTemplate.getForObject(customerInvoicesUri, String[].class, new Object[]{userId});
        return Arrays.asList(invoices);
    }
}
