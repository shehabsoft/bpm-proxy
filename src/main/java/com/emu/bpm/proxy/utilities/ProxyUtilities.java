package com.emu.bpm.proxy.utilities;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Copyright 2021-2022 By Dirac Systems.
 * <p>
 * Created by {@khalid.nouh on 31/3/2021}.
 */

public class ProxyUtilities {
    public static String getE(String user, String password) {
        try {
            return Base64.getEncoder().encodeToString((user + ":" + password).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }
}
