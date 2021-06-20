package com.emu.bpm.proxy.integration.config;


//import org.emu.common.events.MemberEvent;

import org.emu.common.events.MemberApprovalEvent;
import org.emu.common.events.MemberEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class MemberConfig {



    @Bean
    public Supplier<Flux<MemberEvent>> memberSupplier(Sinks.Many<MemberEvent> sink) {
        return sink::asFlux;
    }



    @Bean
    public Sinks.Many<MemberEvent> member() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }





}
