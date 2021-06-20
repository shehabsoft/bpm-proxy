package com.emu.bpm.proxy.integration.config;


import org.emu.common.events.NotificationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class NotificationConfig {



    @Bean
    public Sinks.Many<NotificationEvent> notificationSink(){
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<NotificationEvent>> notificationSupplier(Sinks.Many<NotificationEvent> sink){
        return sink::asFlux;
    }

}
