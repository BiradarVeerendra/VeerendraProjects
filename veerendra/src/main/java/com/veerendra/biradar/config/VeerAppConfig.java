//package com.veerendra.biradar.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//
//@Configuration
//@EnableRedisRepositories(basePackages = "com.veerendra.biradar.repository")
//public class VeerAppConfig {
//
//    @Autowired
//    private RedisProperties redisProperties;
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
//        redisStandaloneConfiguration.setPassword(redisProperties.getPassword());
//        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder()
//                .connectTimeout(redisProperties.getTimeout())
//                .readTimeout(redisProperties.getJedis().getPool().getMaxWait());
//        if (redisProperties.isSsl())
//            builder.useSsl();
//        // Final JedisClientConfiguration
//        JedisClientConfiguration clientConfig = builder.build();//.usePooling().build();
//        return new JedisConnectionFactory(redisStandaloneConfiguration, clientConfig);
//    }
//
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate() {
//        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
//        JedisConnectionFactory factory = jedisConnectionFactory();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//
//}
