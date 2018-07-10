package top.rzclK.test;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 自己玩玩 不要拿来使用
 * @author wk
 *
 */
public class RequesTestFor {

	public static void main(String[] args) throws ClientProtocolException, IOException {
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
		for(int i=10000;i<99999;i++){
			HttpClient client = new DefaultHttpClient();
//			HttpPost get = new HttpPost("http://www.loljuedi.com/my/ka.html?hao=AQ2017102631964");
		 	HttpPost get = new HttpPost("http://www.loljuedi.com/My/order.html?act=check&orderid="+format+f.format(i));
		 	JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
		 	HashMap<String, String> resultMap = new HashMap<String, String>();
		 	HttpResponse res = null;
		 	try {
		 		res = client.execute(get);
			} catch (Exception e) {
				i--;
				continue;
			}
	 			String responseContent = null; // 响应内容
	 			HttpEntity entity = res.getEntity();
	 			responseContent = EntityUtils.toString(entity, "UTF-8");
	 			if(!responseContent.equals("")){
	 				System.out.println(format+f.format(i));
	 				try {
	 					JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
	 					System.out.println(json.toString());
					} catch (Exception e) {
						i--;
					}
	 				
	 				
	 			}
	}
}
}
