package top.rzclk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 程序入口类
 * @author wangk
 *
 */
@SpringBootApplication
public class RApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RApplication.class);
	}
}
