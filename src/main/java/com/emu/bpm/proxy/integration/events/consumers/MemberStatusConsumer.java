package com.emu.bpm.proxy.integration.events.consumers;

import com.emu.bpm.proxy.integration.events.handlers.MemberEventHandler;
import org.emu.common.dto.MemberStatus;
import org.emu.common.events.MemberEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MemberStatusConsumer {

    private final Logger log = LoggerFactory.getLogger(MemberStatusConsumer.class);

    @Autowired
    private MemberEventHandler orderEventHandler;

    @Bean
    public Consumer<MemberEvent> memberEventConsumer() {
        return me -> {
            me.setType("MemberEvent");
            System.out.println("MemberEvent-------------");
            if(me.getStatus() != null && me.getStatus().toString().equals("CREATED")) {
                orderEventHandler.fireMemberProcess(me);
            }
        };
    }
}
