package com.emu.bpm.proxy.integration.events.publishers;

import org.emu.common.dto.MemberApprovalDto;
import org.emu.common.dto.MemberDto;
import org.emu.common.dto.MemberStatus;
import org.emu.common.dto.NotifactionDto;
import org.emu.common.events.MemberApprovalEvent;
import org.emu.common.events.MemberEvent;
import org.emu.common.events.NotificationEvent;
import org.emu.common.status.MemberApprovalStatus;


import org.emu.common.status.NotificationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class MemberStatusPublisher {

    private final Logger log = LoggerFactory.getLogger(MemberStatusPublisher.class);



    @Autowired
    private Sinks.Many<MemberApprovalEvent> memberApprovalSink;

    public void raiseMemberApprovalEvent(final MemberDto member, MemberApprovalStatus memberStatus) {

        MemberApprovalDto dto = new MemberApprovalDto();
        dto.setId(member.getId());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
      //  dto.setApproved(memberStatus.equals(MemberApprovalStatus.APPROVED) ? true : false);
        //
        var memberEvent = new MemberApprovalEvent(dto, memberStatus);
        this.memberApprovalSink.tryEmitNext(memberEvent);
    }

    @Autowired
    private Sinks.Many<MemberEvent> memberEventSink;

    public void raiseMemberEvent(final MemberDto member, MemberStatus memberStatus) {
        MemberDto dto = new MemberDto();
        dto.setId(member.getId());
        dto.setMemberStatus(memberStatus);
        var memberEvent = new MemberEvent(dto, memberStatus,"124344");
        this.memberEventSink.tryEmitNext(memberEvent);
    }


    @Autowired
    private Sinks.Many<NotificationEvent> notificationSink;

    public void raiseNotificationEvent(final MemberDto member, String traceId) {
        //
        NotifactionDto dto = new NotifactionDto();
        dto.setId(0);
        dto.setMemberId(member.getId());
        dto.setMsg(member.getFirstName() + " " + member.getLastName());
        //
        var memberEvent = new NotificationEvent(dto, NotificationStatus.NEW,traceId);
        memberEvent.setTraceid(traceId);
        this.notificationSink.tryEmitNext(memberEvent);
    }
}
