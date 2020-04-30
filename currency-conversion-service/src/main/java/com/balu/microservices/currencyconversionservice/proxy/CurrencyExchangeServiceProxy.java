package com.balu.microservices.currencyconversionservice.proxy;


import com.balu.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service" , url = "localhost:8000")
//As we have ribbonClient URL from FeignClient is not required.
//@FeignClient(name = "currency-exchange-service")
//As we are using Zuul API gateway, we are directly connecting Zuul API proxy.
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
//    @GetMapping("/currency-exchange/from/{from}/to/{to}")

    //As we have configured Zuul API Gateway, we need to provide the service name in the URI.
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
                                                        @PathVariable("to") String to);
}
