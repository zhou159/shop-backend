package com.zhou.shop.common;

import java.io.File;

/**
 * 基础常量池
 *
 * @author 周雄
 * @description: 基础常量池
 * @version: v1.0 22.6.9 创建
 * @since 2022/6/9 15:48
 */
public class BaseConstant {
    public static final String SLASH = "/";
    public static final String DOUBLE_SLASH = "//";
    public static final String BACK_SLASH = "\\";

    public static final String ZERO_STR = "0";
    public static final String NULL_STR = "null";
    public static final String NULL_STR_UPPER = "NULL";

    public static final String API_RESULT_DATA_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final Integer SUCCESS_DEFAULT_CODE = 20000;
    public static final String SUCCESS_DEFAULT_MSG = "success";
    public static final Integer MAP_DEFAULT_SIZE = 16;
    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String IP_UNKNOWN = "unknown";
    public static final String REDIS_SERVER_CROUP_KEY = "SAAS_SERVER";
    public static final String FILE_SEPARATOR;
    public static final String TRUE_STR = "true";
    public static final String FALSE_STR = "false";
    public static final boolean TRUE_BOOL = true;
    public static final boolean FALSE_BOOL = false;
    public static final String AUTHORIZATION_TOKEN_KEY = "token";
    public static final String WEBSITE_SUFFIX = ".com";
    public static final String WEBSITE_PREFIX = "www.";
    public static final String NACOS_PREFIX = "lb://";
    public static final String CHARACTER_ENCODE_UTF8_LOWER = "utf-8";
    public static final String CHARACTER_ENCODE_UTF8_UPPER = "UTF-8";
    public static final String CHARACTER_ENCODE_ISO88591 = "ISO-8859-1";
    public static final String CHARACTER_ENCODE_GBK = "GBK";
    public static final String CHARACTER_COMMA = ",";
    public static final String CONNECTOR_UNDERLINE = "_";
    public static final String BACKSLASH = "/";

    public static final String DECIMAL_POINT = ".";
    public static final String REPLACE_DECIMAL_POINT = "\\.";
    public static final String BRACE_LEFT = "{";
    public static final String BRACE_RIGHT = "}";
    public static final String USER_AGENT = "User-Agent";
    public static final String MSIE = "MSIE";
    public static final String TRIDENT = "TRIDENT";
    public static final String EDGE = "EDGE";
    public static final String CHAR_U_UPPER = "U";
    public static final String CHAR_AND = "&";
    public static final String DOUBLE_CHAR_AND = "&";
    public static final String CHAR_COMMA = ",";
    public static final String CHAR_PERCENT = "%";
    public static final String CHAR_INFINITE = "∞";
    public static final String COLON = ":";
    public static final String CHAR_B_LOWER = "b";
    public static final char CHAR_A_UPPER = 'A';
    public static final char CHAR_A_LOWER = 'a';
    public static final char CHAR_Z_UPPER = 'Z';
    public static final char CHAR_Z_LOWER = 'z';
    public static final String EEC_FACTORY_TYPE = "EC";
    public static final String EEC_SIGNATURE_TYPE = "SHA256withECDSA";
    public static final String MD5_SIGNATURE_TYPE = "md5";
    public static final String SHA_256_SIGNATURE_TYPE = "SHA-256";
    public static final String SHA_1_SIGNATURE_TYPE = "SHA-1";
    public static final String HMAC_SHA1_SIGNATURE_TYPE = "HmacSHA1";
    public static final boolean API_TO_UPPER = true;
    public static final boolean API_URL_ENCODE = true;
    public static final String PLACEHOLDER_BLANK_SPACE = " ";
    public static final String PLACEHOLDER_WARP_SPACE = "\n";
    public static final String DASH_LINE = "-";
    public static final String SEMICOLON = ";";
    public static final String HTML_SUFFIX = ".html";

    private BaseConstant() {
    }

    static {
        FILE_SEPARATOR = File.separator;
    }
}
