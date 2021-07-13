package com.emu.bpm.proxy.integration.events.publishers;


import com.emu.bpm.proxy.domain.Notification;
import org.emu.common.dto.NotifactionDto;
import org.emu.common.events.NotificationEvent;
import org.emu.common.status.NotificationStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class NotificationStatusPublisher {


    @Autowired
    private Sinks.Many<NotificationEvent> notificationSink;

    public void raiseNotificationEvent(final Notification note, NotificationStatus status, String traceId){
    	//
    	NotifactionDto dto = new  NotifactionDto();
    	//dto.setId(note.getId());
    	 dto.setMemberId(note.getMemberId());
      //   dto.setMsg(note.getDetails());
    	//
        var memberEvent = new NotificationEvent(dto, status,traceId);
        memberEvent.setTraceid(traceId);
        memberEvent.setType("NotificationSentEvent");
        this.notificationSink.tryEmitNext(memberEvent);
    }


}
