package com.bip.FabrickTest.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

@Configuration
public class ClientUtil {
    private static final String X_TIME_ZONE = "Europe/Rome";
    private static final String API_KEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
    private static final String AUTH_SCHEMA = "S2S";


    public HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Auth-Schema", AUTH_SCHEMA);
        headers.set("Api-Key", API_KEY);
        headers.set("X-Time-Zone", X_TIME_ZONE);
        return headers;
    }
}
