package com.yandex.metrica.impl.ob;

import android.util.Log;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.plugins.PluginErrorDetails;

/* loaded from: classes3.dex */
public class Nf implements IPluginReporter {
    private final Yf a;
    private final com.yandex.metrica.f b;
    private final ICommonExecutor c;
    private final InterfaceC1206qm<M0> d;

    class a implements Runnable {
        final /* synthetic */ PluginErrorDetails a;

        a(PluginErrorDetails pluginErrorDetails) {
            this.a = pluginErrorDetails;
        }

        @Override // java.lang.Runnable
        public void run() {
            Nf.a(Nf.this).reportUnhandledException(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ PluginErrorDetails a;
        final /* synthetic */ String b;

        b(PluginErrorDetails pluginErrorDetails, String str) {
            this.a = pluginErrorDetails;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Nf.a(Nf.this).reportError(this.a, this.b);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ PluginErrorDetails c;

        c(String str, String str2, PluginErrorDetails pluginErrorDetails) {
            this.a = str;
            this.b = str2;
            this.c = pluginErrorDetails;
        }

        @Override // java.lang.Runnable
        public void run() {
            Nf.a(Nf.this).reportError(this.a, this.b, this.c);
        }
    }

    public Nf(Yf yf, com.yandex.metrica.f fVar, ICommonExecutor iCommonExecutor, InterfaceC1206qm<M0> interfaceC1206qm) {
        this.a = yf;
        this.b = fVar;
        this.c = iCommonExecutor;
        this.d = interfaceC1206qm;
    }

    static IPluginReporter a(Nf nf) {
        return nf.d.a().getPluginExtension();
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        if (!this.a.a(pluginErrorDetails, str)) {
            Log.w("AppMetrica", "Error stacktrace must be non empty");
        } else {
            this.b.getClass();
            this.c.execute(new b(pluginErrorDetails, str));
        }
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.a.reportUnhandledException(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new a(pluginErrorDetails));
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.a.reportError(str, str2, pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new c(str, str2, pluginErrorDetails));
    }
}
