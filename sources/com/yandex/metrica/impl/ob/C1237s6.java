package com.yandex.metrica.impl.ob;

import com.yandex.metrica.plugins.PluginErrorDetails;

/* renamed from: com.yandex.metrica.impl.ob.s6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1237s6 {
    private final A0 a;

    public C1237s6(A0 a0) {
        this.a = a0;
    }

    public final H6 a(PluginErrorDetails pluginErrorDetails) {
        return I6.a(pluginErrorDetails.getExceptionClass(), pluginErrorDetails.getMessage(), pluginErrorDetails.getStacktrace(), pluginErrorDetails.getPlatform(), pluginErrorDetails.getVirtualMachineVersion(), pluginErrorDetails.getPluginEnvironment(), this.a.a(), this.a.b());
    }
}
