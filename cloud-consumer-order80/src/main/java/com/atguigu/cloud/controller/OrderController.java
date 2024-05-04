package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    //public static final String PaymentSrv_URL = "http://localhost:8001";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id")  Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }

    @GetMapping("/consumer/pay/del/{id}")
    public Object delOrder(@PathVariable("id") Integer id) {
        return restTemplate.exchange(PaymentSrv_URL+ "/pay/del/" + id, HttpMethod.DELETE, null, ResultData.class).getBody();
    }

    @GetMapping("/consumer/pay/update")
    public Object delOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.exchange(PaymentSrv_URL+ "/pay/update", HttpMethod.PUT, new HttpEntity<>(payDTO), ResultData.class).getBody();
    }


    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}
