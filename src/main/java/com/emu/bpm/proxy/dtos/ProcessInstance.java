package com.emu.bpm.proxy.dtos;
import java.util.Arrays;

/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by {@khalid.nouh on 18/3/2021}.
 */

public class ProcessInstance {
    private  String id;
    private  String definitionId;
    private  String businessKey;
    private  String caseInstanceId;
    private  String ended;
    private  String suspended;
    private  String tenantId;
private  LinkDto[]links;

    @Override
    public String toString() {
        return "ProcessInstance{" +
            "id='" + id + '\'' +
            ", definitionId='" + definitionId + '\'' +
            ", businessKey='" + businessKey + '\'' +
            ", caseInstanceId='" + caseInstanceId + '\'' +
            ", ended='" + ended + '\'' +
            ", suspended='" + suspended + '\'' +
            ", tenantId='" + tenantId + '\'' +
            ", links=" + Arrays.toString(links) +
            '}';
    }

    public LinkDto[] getLinks() {
        return links;
    }

    public void setLinks(LinkDto[] links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getSuspended() {
        return suspended;
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
