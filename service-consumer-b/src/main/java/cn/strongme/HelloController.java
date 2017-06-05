package cn.strongme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 阿水 on 2017/5/27 14:16.
 */
@RestController
public class HelloController {

    @Autowired
    private SchedualServiceHello schedualServiceHello;

    @RequestMapping("hello")
    public String sayHello() {
        return schedualServiceHello.sayHelloFromClientOne();
    }

}
