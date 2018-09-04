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
@DefaultProperties(groupKey = "Customers")
public class CustomerService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand
    public String greeting(String username) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Hello customer %s!", username);
    }

    @HystrixCommand
    public String getCustomerInfo(Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Customer info for user - %s - is blablabla", userId);
    }
}
