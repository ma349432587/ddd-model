package com.mango.medical.utils.uuid;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * KeyGeneratorFactory
 *
 * @author maxiaoyao
 * @date 2018-07-24 10:49
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KeyGeneratorFactory {

    /**
     * 创建主键生成器.
     *
     * @param keyGeneratorClass 主键生成器类
     * @return 主键生成器实例
     */
    public static KeyGenerator createKeyGenerator(final Class<? extends KeyGenerator> keyGeneratorClass) {
        try {
            return keyGeneratorClass.newInstance();
        } catch (final InstantiationException | IllegalAccessException ex) {
            throw new IllegalArgumentException(String.format("Class %s should have public privilege and no argument constructor", keyGeneratorClass.getName()));
        }
    }
}
