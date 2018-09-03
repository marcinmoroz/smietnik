package com.example.CustomerContracts.resources;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
public class CustomerContractResource  {

    public static Integer waitTimeMilliseconds = 1000;

    @GetMapping("/{userId}/getCustomerContracts")
    public List<String> getCustomerContracts(@PathVariable("userId") Integer userId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(waitTimeMilliseconds);
        var contracts = new ArrayList<String>() {{ add("Contract1");add("Contract2");add("Contract3");}};
        return contracts;
    }
}
