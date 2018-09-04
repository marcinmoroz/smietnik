package com.example.HystrixPresentation.services;

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
public class CustomerServiceV1 {
    @Autowired
    RestTemplate restTemplate;

    @Value("${customer.contractsUri}")
    private String customerContractsUri;

    @Value("${customer.invoicesUri}")
    private String customerInvoicesUri;

    public String greeting(String username) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Hello customer %s!", username);
    }

    public String getCustomerInfo(Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        return String.format("Customer info for user - %s - is blablabla", userId);
    }

    public List<String> getCustomerContracts(Integer userId) throws InterruptedException {
        var contracts = restTemplate.getForObject(customerContractsUri, String[].class, new Object[]{userId});
        return Arrays.asList(contracts);
    }

    public List<String> getCustomerInvoices(Integer userId) throws InterruptedException {
        var invoices = restTemplate.getForObject(customerInvoicesUri, String[].class, new Object[]{userId});
        return Arrays.asList(invoices);
    }
}
