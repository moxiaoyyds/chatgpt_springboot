package cn.wanghao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author WangHao
 * @Description
 * @createTime 2023-02-08 21:19
 **/

/**
 * 将token、timestamp、nonce 三个参数进行字典序排序，
 * 然后将三个参数字符串拼接成一个字符串进行 sha1 加密，
 * 最后开发者获得加密后的字符串可与 signature 对比，标识该请求来源于微信。
 */
public class SHA1 {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) throws Exception {
        if (str == null) {
            return null;
        }

        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        messageDigest.update(str.getBytes());
        return getFormattedText(messageDigest.digest());
    }
}
