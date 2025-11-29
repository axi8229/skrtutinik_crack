package com.yandex.metrica.plugins;

/* loaded from: classes3.dex */
public interface IPluginReporter {
    void reportError(PluginErrorDetails pluginErrorDetails, String str);

    void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails);

    void reportUnhandledException(PluginErrorDetails pluginErrorDetails);
}
