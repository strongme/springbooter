package cn.strongme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@RestController
public class ServiceConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigClientApplication.class, args);
	}

	@Value("${foo}")
	private String foo;

	@Autowired
	private Environment environment;

	@RequestMapping(value = "/hello")
	public String hi(){
		if(environment!=null) {
			return String.format("Foo:%s \nBar:%s", environment.getProperty("foo"), environment.getProperty("bar"));
		}else {
			return "Oops, Environment is Null!";
		}
	}
}
