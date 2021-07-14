package com.bigdata.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zzs
 * @date 2021/7/14 17:10
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/instance")
    public List<ServiceInstance> getInstance() {
        return discoveryClient.getInstances("provider");
    }

//    @GetMapping("/getPort/1")
//    public String getPort1() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
//        int randomIndex = ThreadLocalRandom.current().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(randomIndex);
//        String requestUrl = serviceInstance.getUri() + "/getPort";
//        return restTemplate.getForObject(requestUrl, String.class);
//    }

    @GetMapping("/getPort/2")
    public String getPort2() {
        return restTemplate.getForObject("http://provider/getPort", String.class);
    }
}
