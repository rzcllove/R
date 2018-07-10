package top.rzclk.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.tools.Tool;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@SuppressWarnings("deprecation")
public class WxUtil {
	/**
     * 生成用于获取access_token的Code的Url
     *
     * @param redirectUrl
     * @return
     */
	 public static String getRequestCodeUrl(String redirectUrl) {
		
			return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect",
					ToolUtil.getAPPid(), redirectUrl);
	    }
	 /**
	  * 获取openid acctoken
	  * @param code
	  * @return
	  */
	 @SuppressWarnings({ "finally" })
	public static HashMap<String, String> getOpenId(String code){
	 	String turl = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", 
	 			ToolUtil.getAPPid(), ToolUtil.getAppSecret(),code);
	 	@SuppressWarnings({ "resource" })
		HttpClient client = new DefaultHttpClient();
	 	HttpGet get = new HttpGet(turl);
	 	JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	 	HashMap<String, String> resultMap = new HashMap<String, String>();
		try{
 			HttpResponse res = client.execute(get);
 			String responseContent = null; // 响应内容
 			HttpEntity entity = res.getEntity();
 			responseContent = EntityUtils.toString(entity, "UTF-8");
 			JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
 			
 			// 将json字符串转换为json对象
 			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
 				if (json.get("errcode") != null) {
 					// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
 					
 				}else{// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
 					String openid = json.get("openid").getAsString();
 					String access_token = json.get("access_token").getAsString();
 					
 					resultMap.put("openid", openid);
 					resultMap.put("access_token", access_token);
 					
 				}
 			}
 		}catch (Exception e){
 			e.printStackTrace();
 		}finally{
 			// 关闭连接 ,释放资源
 			client.getConnectionManager().shutdown();
 			return resultMap;
 		}
 
	 }
	 
	 	@SuppressWarnings({ "resource", "finally" })
		public static HashMap<String, Object> getWeixinMsg(String access_token,String openid){
	 		String turl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", 
	 					access_token, openid);
	 		HttpClient client = new DefaultHttpClient();
	 		HttpGet get = new HttpGet(turl);
	 		JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	 		HashMap<String, Object> resultMap = new HashMap<String, Object>();
	 		try{
	 			HttpResponse res = client.execute(get);
	 			String responseContent = null; // 响应内容
	 			HttpEntity entity = res.getEntity();
	 			responseContent = EntityUtils.toString(entity, "UTF-8");
	 			JsonObject json  = jsonparer.parse(responseContent).getAsJsonObject();
	 			// 将json字符串转换为json对象
	 			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	 				if (json.get("errcode") != null) {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	 					resultMap.put("errcode", json.get("errcode").getAsString());
	 					resultMap.put("errmsg", json.get("errmsg").getAsString());
	 					return resultMap;
	 				}
	 				JsonArray asJsonArray = json.get("privilege").getAsJsonArray();
	 				String privilege ="";
	 				for(int i=0;i<asJsonArray.size();i++){
	 					JsonElement jsonElement = asJsonArray.get(i);
	 					String asString = jsonElement.getAsString();
	 					privilege+=","+asString;
	 				}
	 				if(!"".equals(privilege)){
	 					privilege=privilege.substring(1);
	 				}
	 				resultMap.put("id", null);
	 				resultMap.put("openid", json.get("openid").getAsString());
	 				resultMap.put("nickname", json.get("nickname").getAsString());
	 				resultMap.put("sex", json.get("sex").getAsLong());
	 				resultMap.put("province", json.get("province").getAsString());
	 				resultMap.put("city", json.get("city").getAsString());
	 				resultMap.put("country", json.get("country").getAsString());
	 				resultMap.put("headimgurl", json.get("headimgurl").getAsString());
	 				resultMap.put("unionid", json.get("unionid")==null?null:json.get("unionid").getAsString());
	 				resultMap.put("privilege", privilege);
	 				resultMap.put("accessToken", access_token);
	 				return resultMap;
	 			}
	 		}catch (Exception e){
	 			e.printStackTrace();
	 		}finally{
	 			// 关闭连接 ,释放资源
	 			client.getConnectionManager().shutdown();
	 			return resultMap;
	 		}
	 	}
	 	
	 	//参数内容 jsonstr+URL路径发送请求 path
	 	public static String sendPost(String jsonStr, String path) throws IOException {  
	 		 byte[] data = jsonStr.getBytes();  
	         java.net.URL url = new java.net.URL(path);  
	         java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();  
	         conn.setRequestMethod("POST");  
	        
	         conn.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒  
	         conn.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒  
	         // 使用 URL 连接进行输出，则将 DoOutput标志设置为 true  
	         conn.setDoOutput(true);  
	         
	         conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");  
	         // conn.setRequestProperty("Content-Encoding","gzip");  
	         conn.setRequestProperty("Content-Length", String.valueOf(data.length));  
	         conn.setRequestProperty("Charsert", "UTF-8");
	         OutputStream outStream = conn.getOutputStream();// 返回写入到此连接的输出流  
	         outStream.write(data);  
	         outStream.close();// 关闭流  
	         String msg = "";// 保存调用http服务后的响应信息  
	         // 如果请求响应码是200，则表示成功  
	         if (conn.getResponseCode() == 200) {  
	             // HTTP服务端返回的编码是UTF-8,故必须设置为UTF-8,保持编码统一,否则会出现中文乱码  
	             BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
	             msg = in.readLine();  
	             in.close();  
	         }  
	         conn.disconnect();// 断开连接  
	         return msg;   
	    }  
	 	
	 	
	 	//发送get请求
	 	@SuppressWarnings({ "resource", "finally" })
		public static String sendGet(String turl){
	 		String result = "";
	 		HttpClient client = new DefaultHttpClient();
	 		HttpGet get = new HttpGet(turl);
	 		JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	 		try{
	 			HttpResponse res = client.execute(get);
	 			String responseContent = null; // 响应内容
	 			HttpEntity entity = res.getEntity();
	 			responseContent = EntityUtils.toString(entity, "UTF-8");
	 			JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
	 			// 将json字符串转换为json对象
	 			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	 				if (json.get("errcode") != null) {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	 					result = json.toString();
	 				}else{// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
	 					result = json.toString();
	 				}
	 			}
	 		}catch (Exception e){
	 			e.printStackTrace();
	 		}finally{
	 			// 关闭连接 ,释放资源
	 			client.getConnectionManager().shutdown();
	 			return result;
	 		}
	 	}
	 	
	 	//测试post请求
		public static String connectHttpsByPost(String path, Object object,
				File file) {
			String result =null;
	        try {
				java.net.URL url = new java.net.URL(path);  
				 java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();  
				con.setDoInput(true);
				con.setDoOutput(true);
				con.setUseCaches(false); // post方式不能使用缓存
				// 设置请求头信息
				con.setRequestProperty("Connection", "Keep-Alive");
				con.setRequestProperty("Charset", "UTF-8");
				// 设置边界
				String BOUNDARY = "----------" + System.currentTimeMillis();
				con.setRequestProperty("Content-Type",
						"multipart/form-data; boundary="
						+ BOUNDARY);
				// 请求正文信息
				// 第一部分：
				StringBuilder sb = new StringBuilder();
				sb.append("--"); // 必须多两道线
				sb.append(BOUNDARY);
				sb.append("\r\n");
				sb.append("Content-Disposition: form-data;name=\"media\";filelength=\""+file.length()+"\";filename=\""
						+ file.getName() + "\"\r\n");
				sb.append("Content-Type:application/octet-stream\r\n\r\n");
				byte[] head = sb.toString().getBytes("utf-8");
				// 获得输出流
				OutputStream out = new DataOutputStream(con.getOutputStream());
				// 输出表头
				out.write(head);
				// 文件正文部分
				// 把文件已流文件的方式 推入到url中
				DataInputStream in = new DataInputStream(new FileInputStream(file));
				int bytes = 0;
				byte[] bufferOut = new byte[1024];
				while ((bytes = in.read(bufferOut)) != -1) {
					out.write(bufferOut, 0, bytes);
				}
				in.close();
				// 结尾部分
				byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
				out.write(foot);
				out.flush();
				out.close();
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = null;
				try {
					// 定义BufferedReader输入流来读取URL的响应
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String line = null;
					while ((line = reader.readLine()) != null) {
						buffer.append(line);
					}
					if (result == null) {
						result = buffer.toString();
					}

				} catch (IOException e) {
					e.printStackTrace();
					try {
						throw new IOException("数据读取异常");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} finally {
					if (reader != null) {
						reader.close();
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		
		
		 /**
	     * 向指定 URL 发送POST方法的请求
	     * 
	     * @param url
	     *            发送请求的 URL
	     * @param param
	     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	     * @return 所代表远程资源的响应结果
	     */
		public static JSONObject sendPosts(String url, String param) {
			InputStream is = null;
	        ByteArrayOutputStream baos = null;
	        String result = "";
	        try {
	        	 URL realUrl = new URL(url);  
	             // 打开和URL之间的连接  
//	             URLConnection conn = realUrl.openConnection();  
	        	 HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

	        	 //发送Post强求，开启其读写的功能
	             conn.setDoOutput(true);
	             conn.setDoInput(true);
	             //这些参数是看了网上有人的建议，用上之后效果不大
	             conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");  
	             conn.setRequestProperty("accpt", "        text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	             conn.setRequestProperty("User-Agent", "        Mozilla/5.0 (Windows NT 6.1; rv:27.0) Gecko/20100101 Firefox/27.0");
	             conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
	             conn.setRequestProperty("Connection", "        keep-alive");
	             conn.setRequestProperty("Cookie", "        SP.NET_SessionId=rtznindc2qwycf45ixyji2rr");
	             conn.setRequestProperty("Charsert", "UTF-8");
	             conn.setRequestMethod("POST");
	             //发送Post请求
	             conn.connect();
	             OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
	             //发送参数
	             writer.write(param);
	             writer.flush();
	             // 解析响应信息，用了很多种，用了字节流啊，处理流都试过了，这是最后试的那个
	             //主要是不能解决乱码问题，响应的东西还是能够收到，就是乱码
	             baos=new ByteArrayOutputStream();
	             byte[] buf = new byte[1024];
	             int len = 0;
	             is = conn.getInputStream();
	             while((len=is.read(buf))!=-1){
	                     baos.write(buf, 0, len);
	             }
	             baos.flush();
	             //这个utf8给予了太多的希望
	             result = baos.toString("utf8");
	             
	            
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        } finally{
	            try{
	                if(is!=null){
	                    is.close();
	                }
	                if(baos!=null){
	                	baos.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        JSONObject jsonObject=JSONObject.fromObject(result);
	        return jsonObject;
	    } 
		
		
	public static String getAccessToken(){
		//暂定
		return null;
	}
		

}
