package top.rzclK;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import top.rzclk.modules.test.async.AsyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RApplicationTests {
	@Autowired  
    private AsyncTask asyncTask;  
	
	
	
	@Test
	public void contextLoads() throws InterruptedException, ClientProtocolException, IOException {
	      asyncTask.doTask1();  
	}
	
	
	

}
