package cn.strongme;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by 阿水 on 2017/5/26 17:58.
 */
@RestController
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces="application/json")
    public Map<String, Object> hello() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("userList", userService.listAll());
        result.put("serverport", serverPort);
        result.put("from", "client-a");
        return result;
    }

    @RequestMapping("/helloA")
    public String callHelloA(){
        LOG.info("calling trace service-client-a ");
        return "I am Hello A";
    }

    @RequestMapping("/helloToClientB")
    public String callHome(){
        LOG.info("calling trace service-client-a ");
        return restTemplate.getForObject("http://service-client-b/helloToClientA", String.class);
    }

}
