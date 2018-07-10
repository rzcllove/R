package top.rzclk.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * <p>
 * Title: StringEx.java
 * </p>
 * 
 * <p>
 * Description: 通用工具类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author
 * 
 * @date 
 * 
 * @version V1.0
 */
public class StringEx {
	public static HttpServletRequest request;
	/**
	 * 获取随机数
	 */
	public static String getFixLenthString(int strLength) {  
	    Random rm = new Random();  
	    // 获得随机数  
	    double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	    // 返回固定的长度的随机数  
	    return fixLenthString.substring(1, strLength + 1);  
	}
	
	/**
	 * 匹配字符串
	 * @param patternStr
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static boolean matchStr(String patternStr,String str) throws Exception{
		return str.matches(patternStr);
	}
	//计算两个日期之间天数
	public static Integer getDays(String startdate,String enddate)
	{
		int days = 0;
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try{
		    if(startdate!=null && enddate!=null){
		    	long to = df.parse(startdate).getTime();
			    long from = df.parse(enddate).getTime();
			    days = Integer.parseInt((from - to) / (1000 * 60 * 60 * 24)+"");
		    }
	    } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return days;
	}
//	public static String getMileage(String lc, String flag) {
//		String mileage = "";
//		if (null != lc && StringUtils.isNotEmpty(lc)) {
//			lc = lc.trim();
//			String aa = lc.substring(0, 1);
//			if ("-".equals(aa))// 有的里程为负值
//			{
//				lc = lc.substring(1);// 转正
//			}
//			int b = lc.indexOf(".");
//			String k = "";
//			String m = "";
//			if (b > 0) {
//				k = lc.substring(0, b);
//				m = lc.substring(b + 1);
//				if (flag.equals("0")) {
//					if(m.length()==1){
//						mileage = "K" + k + "+" + m + "00";
//					}else if(m.length()==2){
//						mileage = "K" + k + "+" + m + "0";
//					}else{
//						mileage = "K" + k + "+" + m ;
//					}
//				} else {
//					mileage = "K" + k + "+" + m;
//				}
//			}
//		}
//		return mileage;
//	}

	/**
	 * 判断是否为空
	 * 
	 * @param src
	 * @return s
	 */
	public static String tNull(String src) {
		if (src == null || src.equalsIgnoreCase("null")
				|| src.equalsIgnoreCase("undefined"))
			return "";
		return src;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param src
	 * @return s
	 */
	public static Boolean ifNull(String src) {
		if ("".equals(tTrim(src))) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串去左右空格
	 * 
	 * @param src
	 * @return s
	 */
	public static String tTrim(String src) {
		if (src == null || src.equalsIgnoreCase("null")
				|| src.equalsIgnoreCase("undefined"))
			return "";
		return src.trim();
	}

	/**
	 * 数组内容 转换为字符串
	 * 
	 * @param src
	 * @return s
	 */
	public static String array2String(String src[]) {
		String mes = "";
		for (int i = 0; src != null && i < src.length; i++)
			mes += src[i] + ",";
		if (mes.endsWith(","))
			mes = mes.substring(0, mes.length() - 1);
		return mes;
	}

	/**
	 * 判断一个字符串是否是一个串列表的子集
	 * 
	 * @param parent
	 * @param child
	 * @return boolean
	 */

	public static boolean isInList(String parent, String child) {
		parent = "," + parent + ",";
		return parent.indexOf("," + child + ",") > -1;
	}

	/**
	 * 从列表里删除
	 * 
	 * @param parent
	 * @param child
	 * @return s
	 */
	public static String deleteFromList(String parent, String child) {
		if (!isInList(parent, child))
			return parent;
		parent = "," + parent + ",";
		parent = parent.replaceAll("," + child + ",", ",").replaceFirst("^,",
				"").replaceFirst(",$", "");
		return parent;
	}

	/**
	 * 获得根据编码字符信息
	 * 
	 * @param strSource
	 * @return
	 */
//	public static String getStr(String strSource) {
//		String strResult = "";
//		if (strSource != null) {
//			try {
//				String method = request.getMethod();
//				String encodeFlag = BIPropertiesBean.getProperty("encodeFlag");
//				if (!StringEx.isNull(encodeFlag) && encodeFlag.equals("0")) {
//					strResult = new String(strSource.getBytes("ISO8859_1"),
//							"UTF-8");
//				} else {
//					strResult = strSource;
//					if (!StringEx.isNull(method)
//							&& method.toLowerCase().equals("get")) {
//						strResult = new String(strSource.getBytes("ISO8859_1"),
//								"UTF-8");
//					}
//				}
//			} catch (Exception e) {
//				System.out.println(e.toString());
//				strResult = "";
//			}
//		}
//		return strResult;
//	}
	/**
	 * 
	 */
	public static String string2Json(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '\"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '/':
				sb.append("\\/");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
	/**
	 * 获得根据编码字符信息
	 * 
	 * @param strSource
	 * @return
	 */
	public static String getStrOnGet(String strSource) {
		String strResult = "";
		if (strSource != null) {
			try {
				strResult = new String(strSource.getBytes("ISO8859_1"), "UTF-8");
			} catch (Exception e) {
				strResult = "";
			}
		}
		return strResult;
	}

	/**
	 * 往列表里添加内容
	 * 
	 * @param parent
	 * @param child
	 * @return s
	 */
	public static String add2List(String parent, String child) {
		// 验证是否已经存在
		if (isInList(parent, child))
			return parent;
		if (parent.indexOf(",") > -1)
			return parent + "," + child;
		return child;
	}

	/**
	 * @param src
	 * @param length
	 * @return s
	 */
	public static String pop(String src, int length) {
		if (src == null || src.equals(""))
			return "";
		if (src.length() <= length)
			return src;
		return "<span title=\"" + src + "\">" + src.substring(0, length)
				+ "..</span>";
	}

	/**
	 * @param src
	 * @param length
	 * @return s
	 */
	public static String cut(String src, int length) {
		if (src == null || src.equals(""))
			return "";
		if (src.length() <= length)
			return src;
		return src.substring(0, length) + "..";
	}

	/**
	 * 格式化日期为年月日
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateStringYMD(Date date) {
		if (date == null || date.equals(""))
			return null;
		return dateFormat(date, "yyyy-MM-dd");

	}

	/**
	 * 格式化日期为年月日yyyyMMdd
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateStringYMd(Date date) {
		if (date == null || date.equals(""))
			return null;
		return dateFormat(date, "yyyyMMdd");

	}

	/**
	 * @param str要操作的字符串
	 * @param filter要去掉的特殊字符
	 * @return
	 */
	public static String filterStr(String str, List<String> filter) {
		if (!isNull(str) && null != filter && filter.size() > 0) {
			for (String f : filter) {
				str = str.replaceAll(f, "");
			}
		}
		return str;
	}

	public static Timestamp getTS(String p0) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Timestamp ts;
		try {
			d = sdf.parse(p0);
		} catch (Exception e) {
		}
		ts = new Timestamp(d.getTime());
		return ts;
	}

	/**
	 * 格式化日期为dd/MM/yyyy
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateStringDMY(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "dd/MM/yyyy");

	}

	/**
	 * 格式化日期为月日
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateStringMD(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "MM-dd");

	}

	/**
	 * 格式化日期为yyyy年MM月dd日
	 * 
	 * @param date
	 * @return s
	 */
	public static String getStringYMD(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "yyyy年MM月dd日");
	}

	/**
	 * 格式化日期为年月日 时分秒 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateStringYMDHMS(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化日期为周、日期
	 * 
	 * @param date
	 * @return s
	 */
	@SuppressWarnings("deprecation")
	public static String getDateStringWeek(Date date, String format) {
		if (date == null || date.equals(""))
			return "";

		int week = date.getDay();
		String dataStr = dateFormat(date, format);
		switch (week) {
		case 1:
			dataStr = "星期一" + "[" + dataStr + "]";
			break;

		case 2:
			dataStr = "星期二" + "[" + dataStr + "]";
			break;

		case 3:
			dataStr = "星期三" + "[" + dataStr + "]";
			break;

		case 4:
			dataStr = "星期四" + "[" + dataStr + "]";
			break;

		case 5:
			dataStr = "星期五" + "[" + dataStr + "]";
			break;

		case 6:
			dataStr = "星期六" + "[" + dataStr + "]";
			break;

		default:
			dataStr = "星期日" + "[" + dataStr + "]";
		}
		;
		return dataStr;
	}

	/**
	 * 格式化日期为yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateStringYMDHM(Date date) {
		if (date == null || date.equals(""))
			return "";

		String dataStr = dateFormat(date, "yyyy-MM-dd HH:mm");
		return dataStr;
	}

	/**
	 * 格式化日期为yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return s
	 */
	@SuppressWarnings("deprecation")
	public static String changDayOfWeek(Date date) {
		if (date == null || date.equals(""))
			return "";

		int week = date.getDay();
		String dataStr = "";
		switch (week) {
		case 1:
			dataStr += "周一";
			break;

		case 2:
			dataStr += "周二";
			break;

		case 3:
			dataStr += "周三";
			break;

		case 4:
			dataStr += "周四";
			break;

		case 5:
			dataStr += "周五";
			break;

		case 6:
			dataStr += "周六";
			break;

		default:
			dataStr += "周日";
		}
		;

		return dataStr;
	}

	/**
	 * 格式化日期为年月日 时分秒
	 * 
	 * @param date
	 * @return s
	 */
	public static String getDateString(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "yyyyMMddHHmmss");
	}

	/**
	 * 格式化日期为年月日 时分秒
	 * 
	 * @param date
	 * @return s
	 */
	public static String getStringYMDHMS(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "yyyy年MM月dd日 HH时mm分ss秒");
	}

	/**
	 * 格式化日期为月日 时分秒
	 * 
	 * @param date
	 * @return s
	 */
	public static String getStringMDHM(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "MM月dd日 HH时mm分");
	}
	
	public static String getStringHM(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "HH:mm");
	}

	public static String getStringHMS(Date date) {
		if (date == null || date.equals(""))
			return "";
		return dateFormat(date, "HH:mm:ss");
	}

	/**
	 * 字符串转化为时间 yyyyMMdd
	 * 
	 * @param str
	 * @return date
	 * @throws ParseException
	 */
	public static Date getStrDateFormat(String string) throws ParseException {
		if (string == null || "".equals(string))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(string);
	}

	/**
	 * 字符串转换为日期型数据
	 * 
	 * @param src
	 * @return date
	 */
	public static Date parseDate(String src) {
		if (!src.matches("\\d{4}-\\d{1,2}-\\d{1,2}"))
			return null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 字符串转换为日期型数据
	 * 
	 * @param src
	 * @return date
	 */
	public static Date parseTime(String src) {
		if (!src.matches("\\d{1,2}:\\d{2}"))
			return null;
		SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 字符串转换为日期型数据
	 * 
	 * @param src
	 * @return date
	 */
	public static Date parseDateAndTime(String src) {
		if (!src.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}"))
			return null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseMDAndTime(String src) {
		if (!src.matches("\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{2}:\\d{2}"))
			return null;
		SimpleDateFormat sf = new SimpleDateFormat("MM-dd HH:mm:ss");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 时间转化为字符串
	 * 
	 * @param date
	 * @param format
	 * @return s
	 */
	public static String dateFormat(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 验证一个串是否是一个数字组合 用于GET参数传递的验证
	 * 
	 * @param src
	 * @return b
	 */
	public static boolean isNumber(String src) {
		if (src == null || src.equals(""))
			return false;
		return src.matches("^\\d{1,}(.\\d{1,})?$");
	}

	/**
	 * 判断一个字串是否为空
	 * 
	 * @param src
	 * @return b
	 */
	public static boolean isNull(String src) {
		boolean flag = src == null || src.equals("") || src.equals("null") || src.equals("undefined");
		if(!flag){
			src = src.trim();
			flag = src == null || src.equals("") || src.equals("null") || src.equals("undefined");
		}
		return flag;
	}

	/**
	 * 转换带分隔符串为Integer数组 后台中用到
	 * 
	 * @param src
	 * @return integer[]
	 */
	public static Integer[] getIntegerFromString(String src) {
		if (!src.matches("^\\d+[,\\d+]{0,}\\d{0,}$"))
			return new Integer[] {};
		String _src[] = src.split(",");
		Integer[] ret = new Integer[_src.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = Integer.valueOf(_src[i]);
		}
		return ret;
	}

	/**
	 * 转换带分隔符串为Long数组 后台中用到
	 * 
	 * @param src
	 * @return long[]
	 */
	public static Long[] getLongFromString(String src) {
		if (!src.matches("^\\d+[,\\d+]{0,}\\d{0,}$"))
			return new Long[] {};
		String _src[] = src.split(",");
		Long[] ret = new Long[_src.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = Long.valueOf(_src[i]);
		}
		return ret;
	}

	/**
	 * 特殊处理文本内容，对关键字可以添加前缀后缀，实现关键字着重显示 例 specilizeText("中国人","国","<font
	 * color=red>","</font>"); 结果为 中<font color=red>国</font>人
	 * 
	 * @param content
	 * @param keywords
	 * @param prefix
	 * @param suffix
	 * @return t
	 */
	public static String specilizeText(String content, String keywords,
			int holdLength, String prefix, String suffix) {
		String reg = keywords.replaceAll("\\s", ".*");
		Pattern p = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(content);

		if (m.find()) {
			// 能匹配
			int start = m.start();
			int end = start + holdLength;
			if (end > content.length())
				end = content.length();
			String temp = (start > 0 ? "..." : "")
					+ content.substring(start, end)
					+ (end < content.length() - 1 ? "..." : "");
			reg = keywords.replaceAll("\\s", "|");
			temp = temp.replaceAll("(" + reg + ")", prefix + "$1" + suffix);
			return temp;
		}
		return cut(content, holdLength);
	}

	/**
	 * 字符串dd/MM/yyyy转换为日期型数据
	 * 
	 * @param src
	 * @return date
	 */
	public static Date parseStringtoDate(String src) {
		if (!src.matches("^\\d{2}/\\d{2}/\\d{4}$"))
			return null;
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 字符串yyyy-MM-dd转换为日期型数据
	 * 
	 * @param src
	 * @return date
	 */
	public static Date parseStringtoDate1(String src) {
		if (!src.matches("^\\d{4}-\\d{2}-\\d{2}$"))
			return null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 计算两个日期之差
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
	/**
	 * 计算两个日期之和
	 * 
	 * @param date
	 * @param date1
	 * @return
	 */
	public static int gotDate(Date date, Date date1) {
		return (int) ((getMillis(date) + getMillis(date1)) /1000);
	}
	public static void main(){
//		int dd = gotDate
	}
	/**
	 * 计算两个日期月份大小
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		try {
			Date dt1 = sdf.parse(DATE1);
			Date dt2 = sdf.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 计算两个日期大小
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_dateYMDHMS(String DATE1, String DATE2) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date dt1 = sdf.parse(DATE1);
			Date dt2 = sdf.parse(DATE2);
			if (dt1.getTime() < dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() > dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * add by ygt at 2009.07.08 字符串转换转换成数组
	 * 
	 * @param ids
	 * @return
	 */
	public static String[] toArryay(String str) {
		if (str.indexOf(",") != -1) {
			return str.split(",");
		} else {
			String myids[] = new String[1];
			myids[0] = str;
			return myids;
		}
	}

	/**
	 * add by ygt at 2009.07.08 字符串转换转换成数组
	 * 
	 * @param ids
	 * @return
	 */
	public static Long[] toLongArryay(String str) {
		Long ls[];
		String[] strs = new String[1];
		if (str.indexOf(",") != -1) {
			int j = str.split(",").length;
			strs = new String[j];
			strs = str.split(",");
		} else {
			strs = new String[1];
			strs[0] = str;
		}
		ls = new Long[strs.length];
		for (int i = 0; i < strs.length; i++) {
			ls[i] = Long.parseLong(strs[i]);
		}
		return ls;
	}

	/**
	 * 获得一个32位的伪随机数
	 * 
	 * @return
	 */
	public static String randomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 根据年月日生成日期
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Date getDate(int year, int month, int date) {
		Calendar cal = new java.util.GregorianCalendar(year, month, date);
		return cal.getTime();
	}

	/**
	 * 字符串转换为日期型数据 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param src
	 * @return date
	 */
	public static Date parseymdhmsDate(String src) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sf.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 根据会员编码生成会员目录路径
	 * 
	 * @param code
	 *            会员编码
	 * @return
	 */
	public static String getUserFolderPath(String code) {
		StringBuffer str = new StringBuffer(code);
		str.insert(3, "/");
		str.insert(7, "/");
		str.insert(11, "/");
		str.insert(13, "/");
		return str.toString();
	}

	/**
	 * 按天数 获取日期
	 * 
	 * @param date
	 * @param num
	 * @return Date
	 */
	public static Date getDateByDateNum(Date date, int num) {
		String dates = getDateStringYMD(date);
		if (num != 0) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			gc.add(Calendar.DATE, num);
			Date day = gc.getTime();
			dates = getDateStringYMD(day);
		}
		return parseDate(dates);
	}
	/**
	 * 将字符串转换为大写或小写 true 大写，false 小写
	 * @param flag
	 * @param str
	 * @return
	 */
	public static String isToUpperOrToLower(String flag, String str) {
		if (flag=="true") {
			return str.toUpperCase();
		} 
		   return str.toLowerCase();
		
	}
	/**
	 * 将年月日时间秒转成16进制
	 * @param flag
	 * @param str
	 * @return
	 * @throws ParseException 
	 */
	public static String strToX8(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (date!=null && date!="") {
			Date dt = sdf.parse(date);
			long timer = dt.getTime()/1000;
			String time = Integer.toHexString((int)timer);
			return time;
		} 
		return null;
	}
	
	public static boolean isObjnull(Object object){
		return object==null?true:false;
	}
	
	public static boolean isNotObjnull(Object object){
		return object==null?false:true;
	}
}
