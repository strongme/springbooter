package cn.strongme;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 阿水 on 2017/6/5 09:35.
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public Map<String, Object> hello() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("msg", "hello from service-consul");
        return result;
    }

}
