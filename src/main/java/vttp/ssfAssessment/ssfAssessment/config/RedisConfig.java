package vttp.ssfAssessment.ssfAssessment.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    private String redisHost;
    private Optional<Integer> redisPort;
    private String redisPassword;

    // @Bean(name = "orderListRedisConfig")
    // @Scope("singletlon")

    
    
}
