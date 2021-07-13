/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by khalid.nouh on 17/3/2021.
 */

package com.emu.bpm.proxy.dtos;

import java.util.Arrays;

/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by {@khalid.nouh on 18/3/2021}.
 */

public class DeploymentDto {
    private LinkDto[]links;
        private String id;
        private String name;
        private String deploymentTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(String deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

    @Override
    public String toString() {
        return "DeploymentDto{" +
            "links=" + Arrays.toString(links) +
            ", id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", deploymentTime='" + deploymentTime + '\'' +
            '}';
    }
}
