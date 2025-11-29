package com.yandex.metrica.impl.ob;

import android.util.Log;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.plugins.PluginErrorDetails;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Tf {
    private final ICommonExecutor a;
    private final Sf b;
    private final Kf c;
    private final Xf d;
    private final com.yandex.metrica.f e;

    static final class a implements Runnable {
        final /* synthetic */ PluginErrorDetails b;
        final /* synthetic */ String c;

        a(PluginErrorDetails pluginErrorDetails, String str) {
            this.b = pluginErrorDetails;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Tf.a(Tf.this).getPluginExtension().reportError(this.b, this.c);
        }
    }

    static final class b implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ PluginErrorDetails d;

        b(String str, String str2, PluginErrorDetails pluginErrorDetails) {
            this.b = str;
            this.c = str2;
            this.d = pluginErrorDetails;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Tf.a(Tf.this).getPluginExtension().reportError(this.b, this.c, this.d);
        }
    }

    static final class c implements Runnable {
        final /* synthetic */ PluginErrorDetails b;

        c(PluginErrorDetails pluginErrorDetails) {
            this.b = pluginErrorDetails;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Tf.a(Tf.this).getPluginExtension().reportUnhandledException(this.b);
        }
    }

    public Tf(ICommonExecutor iCommonExecutor, Sf sf, Kf kf, Xf xf, com.yandex.metrica.f fVar) {
        this.a = iCommonExecutor;
        this.b = sf;
        this.c = kf;
        this.d = xf;
        this.e = fVar;
    }

    public final void a(PluginErrorDetails pluginErrorDetails) {
        this.c.a(null);
        this.d.a().reportUnhandledException(pluginErrorDetails);
        com.yandex.metrica.f fVar = this.e;
        Intrinsics.checkNotNull(pluginErrorDetails);
        fVar.getClass();
        this.a.execute(new c(pluginErrorDetails));
    }

    public Tf(ICommonExecutor iCommonExecutor) {
        this(iCommonExecutor, new Sf());
    }

    private Tf(ICommonExecutor iCommonExecutor, Sf sf) {
        this(iCommonExecutor, sf, new Kf(sf), new Xf(), new com.yandex.metrica.f(sf, new D2()));
    }

    public final void a(PluginErrorDetails pluginErrorDetails, String str) {
        this.c.a(null);
        if (!this.d.a().a(pluginErrorDetails, str)) {
            Log.w("AppMetrica", "Error stacktrace must be non empty");
            return;
        }
        com.yandex.metrica.f fVar = this.e;
        Intrinsics.checkNotNull(pluginErrorDetails);
        fVar.getClass();
        this.a.execute(new a(pluginErrorDetails, str));
    }

    public final void a(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.c.a(null);
        this.d.a().reportError(str, str2, pluginErrorDetails);
        com.yandex.metrica.f fVar = this.e;
        Intrinsics.checkNotNull(str);
        fVar.getClass();
        this.a.execute(new b(str, str2, pluginErrorDetails));
    }

    public static final K0 a(Tf tf) {
        tf.b.getClass();
        R2 r2K = R2.k();
        Intrinsics.checkNotNull(r2K);
        Intrinsics.checkNotNullExpressionValue(r2K, "provider.peekInitializedImpl()!!");
        C1036k1 c1036k1D = r2K.d();
        Intrinsics.checkNotNull(c1036k1D);
        Intrinsics.checkNotNullExpressionValue(c1036k1D, "provider.peekInitialized…rterApiConsumerProvider!!");
        K0 k0B = c1036k1D.b();
        Intrinsics.checkNotNullExpressionValue(k0B, "provider.peekInitialized…erProvider!!.mainReporter");
        return k0B;
    }
}
