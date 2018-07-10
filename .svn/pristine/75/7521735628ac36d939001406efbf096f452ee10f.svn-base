package top.rzclk.common.validator;

import org.apache.commons.lang.StringUtils;

import top.rzclk.common.exception.RException;


/**
 * 数据校验
 * 
 * @author wangk
 * @email rzcllove@163.com
 * @Time 2017年8月9日 下午5:24:03 
 *
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RException(message);
        }
    }
}
