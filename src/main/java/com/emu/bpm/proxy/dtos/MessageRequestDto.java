
package com.emu.bpm.proxy.dtos;
/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by {@khalid.nouh on 18/3/2021}.
 */

public class MessageRequestDto {
    private  String messageName;
        private  String businessKey;

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    @Override
    public String toString() {
        return "MessageRequestDto{" +
            "messageName='" + messageName + '\'' +
            ", businessKey='" + businessKey + '\'' +
            '}';
    }
}
