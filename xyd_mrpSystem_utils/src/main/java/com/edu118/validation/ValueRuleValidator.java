package com.edu118.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 本类专门负责进行各种字符串的数据格式验证
 */
public class ValueRuleValidator {
	private ValueRuleValidator() {
	}

	/**
	 * 进行上传文件类型的检测
	 * 
	 * @param rule
	 *            所有的验证规则
	 * @param contentType
	 *            当前的文件的类型
	 * @return 复合规则返回true
	 */
	public static boolean isMIME(String rule, String contentType) {
		if (isString(contentType) && isString(rule)) {
			String ruleResult[] = rule.split("\\|");
			for (int x = 0; x < ruleResult.length; x++) {
				if (contentType.equals(ruleResult[x])) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isBoolean(String str) {
		if (isString(str)) { // 必须保证数据不为空
			return "true".equals(str) || "false".equals(str);
		}
		return false;
	}

	/**
	 * 进行验证码的检测
	 * 
	 * @param str
	 *            要验证的字符串
	 * @param rand
	 *            生成的验证码
	 * @return 验证码相同返回true
	 */
	public static boolean isRand(String str, String rand) {
		if (isString(str) && isString(rand)) { // 必须保证数据不为空
			return str.equalsIgnoreCase(rand);
		}
		return false;
	}

	public static boolean isDatetime(String str) {
		if (isString(str)) { // 必须保证数据不为空 2012-12-12 12:12:12
			return str.matches("((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
		}
		return false;
	}

	public static boolean isDate(String str) {
		if (isString(str)) { // 必须保证数据不为空
			return str.matches("((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
		}
		return false;
	}

	public static boolean isDouble(String str) {
		if (isString(str)) { // 必须保证数据不为空
			return str.matches("\\d+(\\.\\d+)?");
		}
		return false;
	}

	public static boolean isLong(String str) {
		return isInt(str);
	}

	public static boolean isInt(String str) {
		if (isString(str)) { // 必须保证数据不为空
			return str.matches("\\d+");
		}
		return false;
	}

	/**
	 * 进行字符串是否为空的验证处理
	 * 
	 * @param str
	 *            字符串
	 * @return 如果不为空（null、""）返回true，否则返回false
	 */
	public static boolean isString(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return true;
	}

	/**
	 * 日期的大小比较
	 * 
	 * @param sDate
	 *            开始日期
	 * @param eDate
	 *            结束日期
	 * @return 开始日期 > 结束日期就返回 false
	 */
	public static boolean dateSizeCompare(String sDate, String eDate) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.parse(sDate).after(df.parse(eDate));
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

}
