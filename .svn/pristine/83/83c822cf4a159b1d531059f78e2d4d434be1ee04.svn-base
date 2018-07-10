package top.rzclk.modules.test.async;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Future;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * 
 * @author wangk
 * 线程
 */
@Component("AsyncTask")
public class AsyncTask {
	
	 protected final Logger logger = LoggerFactory.getLogger(this.getClass());    

	 
	
	 @Async("AsyncPool")  
	 public Future<String> doTask1() throws InterruptedException, ClientProtocolException, IOException{  
		 String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			char charAt1 = chars.charAt((int)(Math.random() * 26));
			char charAt2 = chars.charAt((int)(Math.random() * 26));
			String ZM1 = String.valueOf(charAt1);
			String ZM2 = String.valueOf(charAt2);
			long l = System.currentTimeMillis();
			NumberFormat f=new DecimalFormat("00000");
			//new日期对象
			Date date = new Date(l);
			//转换提日期输出格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String format = ZM1+ZM2+dateFormat.format(date);
			for(int i=0;i<99999;i++){
				System.out.println(f.format(i));
				HttpClient client = new DefaultHttpClient();
			 	HttpPost get = new HttpPost("http://www.loljuedi.com/My/order.html?act=check&orderid="+format+f.format(i));
			 	JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
			 	HashMap<String, String> resultMap = new HashMap<String, String>();
		 			HttpResponse res = client.execute(get);
		 			String responseContent = null; // 响应内容
		 			HttpEntity entity = res.getEntity();
		 			responseContent = EntityUtils.toString(entity, "UTF-8");
		 			if(!responseContent.equals("")){
		 				System.out.println(format+f.format(i));
		 				JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
		 				System.out.println(json.toString());
		 				return null;
		 			}
		}
			return null;
	    }  
	      
	    @Async("myAsync")  
	    public Future<String> doTask2() throws InterruptedException{  
	        logger.info("Task2 started.");  
	        long start = System.currentTimeMillis();  
	        Thread.sleep(3000);  
	        long end = System.currentTimeMillis();  
	          
	        logger.info(getClass()+"完成时间: {} ms.", end-start);  
	        return new AsyncResult<>(getClass()+"完成!");  
	    }  
}
