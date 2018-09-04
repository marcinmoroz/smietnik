package com.example.CustomerInvoices.resources;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
public class CustomerInvoiceResource  {

    public Integer waitTimeMilliseconds = 1000;

    @GetMapping("/{userId}/getCustomerInvoices")
    public List<String> getCustomerInvoices(Integer userId) throws InterruptedException {
        //Random random = new Random();
        //TimeUnit.MILLISECONDS.sleep(random.nextInt(waitTimeMilliseconds) + 100);
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        var invoices  =new ArrayList<String>() {{ add("Invoice F1/01/2018");add("Invoice F1/02/2018");add("Invoice F1/02/2018");}};
        return invoices;
    }

    @PutMapping("/waitTime/{newWaitTime}")
    public Integer replaceWaitTime(@PathVariable("newWaitTime") Integer newWaitTime) {
        waitTimeMilliseconds = newWaitTime;
        return newWaitTime;
    }

    @GetMapping("/waitTime")
    public Integer getWaitTime() {
        return waitTimeMilliseconds;
    }
}
