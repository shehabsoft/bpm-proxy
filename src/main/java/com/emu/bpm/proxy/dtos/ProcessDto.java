/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by khalid.nouh on 17/3/2021.
 */

package com.emu.bpm.proxy.dtos;

/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by {@khalid.nouh on 18/3/2021}.
 */
public class ProcessDto {

    private  String id;
    private  String key;
    private  String category;
    private  String description;
    private  String name;
    private  String version;
    private  String resource;
    private  String deploymentId;
    private  String diagram;
    private  String suspended;
    private  String tenantId;
    private  String versionTag;
    private  String historyTimeToLive;
    private  String startableInTasklist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getDiagram() {
        return diagram;
    }

    public void setDiagram(String diagram) {
        this.diagram = diagram;
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

    public String getVersionTag() {
        return versionTag;
    }

    public void setVersionTag(String versionTag) {
        this.versionTag = versionTag;
    }

    public String getHistoryTimeToLive() {
        return historyTimeToLive;
    }

    public void setHistoryTimeToLive(String historyTimeToLive) {
        this.historyTimeToLive = historyTimeToLive;
    }

    public String getStartableInTasklist() {
        return startableInTasklist;
    }

    public void setStartableInTasklist(String startableInTasklist) {
        this.startableInTasklist = startableInTasklist;
    }

    @Override
    public String toString() {
        return "ProcessDto{" +
            "id='" + id + '\'' +
            ", key='" + key + '\'' +
            ", category='" + category + '\'' +
            ", description='" + description + '\'' +
            ", name='" + name + '\'' +
            ", version='" + version + '\'' +
            ", resource='" + resource + '\'' +
            ", deploymentId='" + deploymentId + '\'' +
            ", diagram='" + diagram + '\'' +
            ", suspended='" + suspended + '\'' +
            ", tenantId='" + tenantId + '\'' +
            ", versionTag='" + versionTag + '\'' +
            ", historyTimeToLive='" + historyTimeToLive + '\'' +
            ", startableInTasklist='" + startableInTasklist + '\'' +
            '}';
    }
}
