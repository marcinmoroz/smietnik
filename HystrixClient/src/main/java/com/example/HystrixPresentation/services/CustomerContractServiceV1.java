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
@DefaultProperties(groupKey = "CustomerContracts")
public class CustomerContractServiceV1 {
    @Autowired
    RestTemplate restTemplate;

    @Value("${customer.contractsUri}")
    private String customerContractsUri;

    @HystrixCommand
    public List<String> getCustomerContracts(Integer userId) throws InterruptedException {
        var contracts = restTemplate.getForObject(customerContractsUri, String[].class, new Object[]{userId});
        return Arrays.asList(contracts);
    }
}
