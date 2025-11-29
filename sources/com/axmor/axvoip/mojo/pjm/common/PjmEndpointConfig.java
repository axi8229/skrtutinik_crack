package com.axmor.axvoip.mojo.pjm.common;

import org.pjsip.pjsua2.EpConfig;
import org.pjsip.pjsua2.TransportConfig;

/* loaded from: classes.dex */
public final class PjmEndpointConfig {
    private final EpConfig endpointConfig;
    private final LogcatWriter logcatWriter;
    private final TransportConfig transportConfig;

    public PjmEndpointConfig() {
        EpConfig epConfig = new EpConfig();
        this.endpointConfig = epConfig;
        this.transportConfig = new TransportConfig();
        this.logcatWriter = new LogcatWriter();
        epConfig.getUaConfig().setUserAgent("AX-VoIP Mojo User Agent/");
        configureTransport(6000L);
    }

    public void configureTransport(long j) {
        this.transportConfig.setPort(j);
    }

    public EpConfig getEndpointConfig() {
        return this.endpointConfig;
    }

    public TransportConfig getTransportConfig() {
        return this.transportConfig;
    }

    public void delete() {
        this.endpointConfig.delete();
        this.transportConfig.delete();
        this.logcatWriter.delete();
    }
}
