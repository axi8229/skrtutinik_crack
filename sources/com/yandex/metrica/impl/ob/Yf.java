package com.yandex.metrica.impl.ob;

import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.plugins.PluginErrorDetails;
import com.yandex.metrica.plugins.StackTraceItem;
import java.util.Collection;

/* loaded from: classes3.dex */
public class Yf implements IPluginReporter {
    private final Kn<PluginErrorDetails> a = new Hn(new Gn("Error details"));
    private final Kn<String> b = new Hn(new Fn("Error identifier"));
    private final Kn<Collection<StackTraceItem>> c = new En("Stacktrace");

    public boolean a(PluginErrorDetails pluginErrorDetails, String str) {
        this.a.a(pluginErrorDetails);
        return this.c.a(pluginErrorDetails.getStacktrace()).b();
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        this.a.a(pluginErrorDetails);
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.a.a(pluginErrorDetails);
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.b.a(str);
    }
}
