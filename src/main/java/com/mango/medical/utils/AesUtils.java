package com.mango.medical.utils;

import java.security.MessageDigest;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-08-16 15:09
 */
public class AesUtils {

    public static String encrypt(String content, String key) {
        try {
            //256：密钥生成参数；securerandom：密钥生成器的随机源
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            final byte[] digest = digester.digest(key.getBytes("UTF-8"));

            SecretKey secretKey = new SecretKeySpec(digest, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cryptograph = cipher.doFinal(content.getBytes("UTF-8"));
            return Hex.encodeHexString(cryptograph);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String decrypt(String content, String key) {
        try {
            //256：密钥生成参数；securerandom：密钥生成器的随机源
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            final byte[] digest = digester.digest(key.getBytes("UTF-8"));

            SecretKey secretKey = new SecretKeySpec(digest, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final byte[] bytes = Hex.decodeHex(content.toCharArray());
            byte[] cryptograph = cipher.doFinal(bytes);
            return new String(cryptograph,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {

        String content = "im-av_voip-sdk-web-yys_2018-8-13";
        String password = "zsyy";
        System.out.println("明文：" + content);
        System.out.println("key：" + password);

        final String encrypt = encrypt(password, content);
        System.out.println("密文：" + encrypt);

        String decryptResult = decrypt(encrypt, content);
        System.out.println("解密：" + decryptResult);
    }


}
