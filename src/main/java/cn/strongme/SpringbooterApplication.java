package cn.strongme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "cn.strongme")
@EnableTransactionManagement
public class SpringbooterApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringbooterApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbooterApplication.class, args);
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for(String p : activeProfiles) {
			logger.info("已加载 ["+p+"] 配置");
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				logger.debug(beanName);
			}

		};
	}
}
