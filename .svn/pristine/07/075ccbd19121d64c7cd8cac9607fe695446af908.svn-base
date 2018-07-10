package top.rzclk.common.utils;

import java.util.regex.Pattern;

public class StringUtil {

	 //判断是否是整数（含负号）
    public static  boolean isTnteger(String str){
     Pattern pattern = Pattern.compile("^-?[0-9]+");
     return pattern.matcher(str).matches();
    }
    
  //判断是否是数字（含负号）
    public static boolean isAllNums(String str){
       Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
       return pattern.matcher(str).matches();
       }

}
