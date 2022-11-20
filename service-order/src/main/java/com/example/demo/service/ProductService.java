package com.example.demo.service;

import com.example.demo.constans.ServiceConsts;
import com.example.demo.facade.ProductFacade;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = ServiceConsts.SERVICE_PRODUCT)
public interface ProductService extends ProductFacade {
}
