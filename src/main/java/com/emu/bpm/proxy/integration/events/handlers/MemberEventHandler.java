package com.emu.bpm.proxy.integration.events.handlers;

import com.emu.bpm.proxy.feign.CamundaMicroServiceProxy;
import com.sun.xml.bind.api.Bridge;
import org.emu.common.dto.bpm.BpmEventDto;
import org.emu.common.events.AbstractEvent;
import org.emu.common.events.MemberEvent;
import org.emu.common.events.ValidationEvent;
import org.emu.common.status.MemberApprovalStatus;
import org.emu.common.status.MemberStatus;
import org.emu.common.status.NotificationStatus;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.function.Consumer;

@Service
public class MemberEventHandler {



 @Autowired
 CamundaMicroServiceProxy camundaMicroServiceProxy;
    @Value("${bpm.token}")
    private String bpmToken;
    private final Logger log = LoggerFactory.getLogger(MemberEventHandler.class);


    @Transactional
    public void fireMemberProcess(MemberEvent me) {
       camundaMicroServiceProxy.startProcessByMessageEvent(me,bpmToken);
    }

}
