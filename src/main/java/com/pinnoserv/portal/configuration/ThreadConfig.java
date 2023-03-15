package com.pinnoserv.portal.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadConfig {

    @Value("${datasource.apigateway.threadCorePool:20}")
    private int threadCorePool;

    @Value("${datasource.apigateway.threadMaxPoolSize:50}")
    private int threadMaxPoolSize;

    @Bean
    @Primary
    public TaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadCorePool);
        executor.setMaxPoolSize(threadMaxPoolSize);
        executor.setQueueCapacity(800);
        executor.setThreadNamePrefix("portalThread-");
        executor.initialize();
        return executor;
    }
}