package top.rzclK.test;

import java.util.HashMap;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;


public class NewObject {
	
	/**
	  * 堆和栈的测试 
	  *@param  
	  */
	@Test
	public void NewObjectTest(){
		Integer int1 = new Integer(10);
		Integer int2 = int1;
		int2 = int2+10;
		System.out.println(int1);
	}
	
	@Test
	public void Test(){
		String sql = StringEscapeUtils.escapeSql("LieuditlaCurnerieProvence-Alpes-C？ted'AzurCurbans");
		System.out.println(sql);
	}
	
	
	
	@Test
	public void mappingTest() throws JSONException {
		String s = "{01:2,02:3,3:4,5:6,}";
		if(s != null && s.length()>= 1) {
			if(s.substring(0,1).equals("{") && s.substring(s.length()-1,s.length()).equals("}")) {
				System.err.println("匹配到{}");
				s = s.substring(1,s.length()-1);
				System.out.println(s);
			}
			String[] sSplit = s.split(",");
			HashMap mappingMap = new HashMap();
			for (String mapping : sSplit) {
				if(mapping != null) {
					String[] MapSplit = mapping.split(":");
					if(MapSplit.length == 2) {
						mappingMap.put(MapSplit[0], MapSplit[1]);
					}
				}
			}
			System.out.println(mappingMap.toString());
			JSONObject jsonObject = new JSONObject(mappingMap);
			System.err.println(jsonObject.toString());
		}
	}
	
	


}
