package cn.strongme;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 阿水 on 2017/5/26 17:58.
 */
@RestController
public class HelloController {

    @Value("${custom.name}")
    private String name;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Map<String, Object> hello() {

        Map<String, Object> result = Maps.newHashMap();
        result.put("msg", "hello springboot : "+ name);
        result.put("userList", userService.listAll());
        return result;
    }

}
