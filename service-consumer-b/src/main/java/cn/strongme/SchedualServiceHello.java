package cn.strongme;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 阿水 on 2017/5/27 14:14.
 */
@FeignClient(value = "service-client-a", fallback = SchedualServiceHelloHystric.class)
@Component
public interface SchedualServiceHello {

    @RequestMapping("hello")
    String sayHelloFromClientOne();

}
