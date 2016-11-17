package zhangtao.com.MvvmDemo.utils;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by zhangtao on 16/11/10.
 */

public class md5Sig {
    public static String stringToMD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

    public static String bytesToMD5(byte[] bytes) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }
    public static String getSignature(LinkedHashMap<String, List<String>> params,String secret) throws Exception
    {
        // 先将参数以其参数名的字典序升序进行排序
        TreeMap<String, List<String>> sortedParams = new TreeMap<String, List<String>>(params);

        Set<Map.Entry<String, List<String>>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, List<String>> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue()).append("");
        }
        basestring.append(secret);
        Log.e("sdksahkdhask",basestring.toString());
        return stringToMD5(basestring.toString().replace("[","").replace("]",""));
    }
}
