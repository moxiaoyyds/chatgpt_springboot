package cn.wanghao.utils;

import java.util.Arrays;

/**
 * @author WangHao
 * @Description sha1 加密
 * @createTime 2023-02-08 21:18
 **/
public class CheckUtil {
    public static boolean checkSignature(String signature, String timestamp, String nonce, String token) throws Exception {
        String[] str = new String[]{token, timestamp, nonce};
        //排序
        Arrays.sort(str);
        //拼接字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buffer.append(str[i]);
        }
        //进行sha1加密
        String temp = SHA1.encode(buffer.toString());
        //与微信提供的signature进行匹对
        return signature.equals(temp);
    }
}
