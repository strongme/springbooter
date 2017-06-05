package cn.strongme;

import org.springframework.stereotype.Component;

/**
 * Created by 阿水 on 2017/5/27 14:29.
 */
@Component
public class SchedualServiceHelloHystric implements SchedualServiceHello {

    @Override
    public String sayHelloFromClientOne() {
        return "Sorry, we have a problem -- Feign";
    }
}
