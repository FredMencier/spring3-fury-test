package org.heg.samplefury;

import org.apache.fury.BaseFury;
import org.apache.fury.Fury;
import org.apache.fury.config.Language;
import org.apache.fury.pool.ThreadPoolFury;
import org.heg.samplefury.dto.ClientDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Configuration
public class AppConfig {

    Consumer<Fury> registerCallback = fury -> System.out.println("Object registred");

    @Bean
    @ConditionalOnMissingBean
    public BaseFury furyConfig() {
        ThreadPoolFury threadSafeFury = (ThreadPoolFury) Fury.builder()
                .withLanguage(Language.JAVA)
                .withAsyncCompilation(true)
                .buildThreadSafeFuryPool(1, 1, 20, TimeUnit.DAYS);
        threadSafeFury.register(ClientDto.class);
        threadSafeFury.registerCallback(registerCallback);
        return threadSafeFury;
    }
}
