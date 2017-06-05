package cn.strongme;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 阿水 on 2017/5/27 11:00.
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService() {
        return restTemplate.getForObject("http://service-client-a/hello", String.class);
    }

    public String helloError() {
        return "Sorry, We have a problem -- hystrix";
    }
}
