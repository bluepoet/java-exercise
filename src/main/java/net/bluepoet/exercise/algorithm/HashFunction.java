package net.bluepoet.exercise.algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by daumkakao on 2017. 1. 25..
 */
public class HashFunction {
    public String hash(Object key) {
        String MD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(((String) key).getBytes());
            byte byteData[] = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            MD5 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            MD5 = null;
        }

        return MD5;
    }
}
