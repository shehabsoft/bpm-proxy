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
public class MembershipConfig {



    @Bean
    public Supplier<Flux<MemberApprovalEvent>> memberApprovalSupplier(Sinks.Many<MemberApprovalEvent> sink) {
        return sink::asFlux;
    }



    @Bean
    public Sinks.Many<MemberApprovalEvent> memberApproval() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }





}
