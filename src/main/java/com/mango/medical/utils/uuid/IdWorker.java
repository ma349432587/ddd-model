package com.mango.medical.utils.uuid;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 请填写类的描述
 *
 * @author maxiaoyao
 * @date 2018-09-26 17:00
 */
public class IdWorker {
    static {
        initWorkerId();
    }
    private static void initWorkerId() {
        InetAddress address;
        try {
            // 首先得到IP地址，例如192.168.1.108
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");
        }
        // IP地址byte[]数组形式，这个byte数组的长度是4，数组0~3下标对应的值分别是192，168，1，108
        byte[] ipAddressByteArray = address.getAddress();
        // 由这里计算workerId源码可知，workId由两部分组成：
        // 第一部分(ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11) << Byte.SIZE：ipAddressByteArray[ipAddressByteArray.length - 2]即取byte[]倒数第二个值，即1，然后&0B11，即只取最后2位（IP段倒数第二个段取2位，IP段最后一位取全部8位，总计10位），然后左移Byte.SIZE，即左移8位（因为这一部分取得的是IP段中倒数第二个段的值）；
        // 第二部分(ipAddressByteArray[ipAddressByteArray.length - 1] & 0xFF)：ipAddressByteArray[ipAddressByteArray.length - 1]即取byte[]最后一位，即108，然后&0xFF，即通过位运算将byte转为int；
        // 最后将第一部分得到的值加上第二部分得到的值就是最终的workId
        DefaultKeyGenerator.setWorkerId(
            (long) (((ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11) << Byte.SIZE) + (
                ipAddressByteArray[ipAddressByteArray.length - 1] & 0xFF)));
    }

    public static Long getId() {
        final KeyGenerator keyGenerator = KeyGeneratorFactory.createKeyGenerator(DefaultKeyGenerator.class);
        return (Long) keyGenerator.generateKey();
    }
}
