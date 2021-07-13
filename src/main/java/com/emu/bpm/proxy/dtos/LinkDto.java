package com.emu.bpm.proxy.dtos;
/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by {@khalid.nouh on 18/3/2021}.
 */

public class LinkDto {
     private String method;
    private String href;
    private String rel;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public String toString() {
        return "LinkDto{" +
            "method='" + method + '\'' +
            ", href='" + href + '\'' +
            ", rel='" + rel + '\'' +
            '}';
    }
}
