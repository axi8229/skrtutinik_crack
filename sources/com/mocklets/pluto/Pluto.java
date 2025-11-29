package com.mocklets.pluto;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mocklets.pluto.modules.exceptions.ANRListener;
import java.lang.Thread;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pluto.kt */
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\f\u001a\u00020\u00042&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/mocklets/pluto/Pluto;", "", "()V", "initialize", "", "context", "Landroid/content/Context;", "shouldShowIntroToast", "", "setANRListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/mocklets/pluto/modules/exceptions/ANRListener;", "setAppProperties", "properties", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setExceptionHandler", "uncaughtExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "pluto-no-op_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Pluto {
    public static final Pluto INSTANCE = new Pluto();

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initialize$default(this, context, false, 2, null);
    }

    public final void initialize(Context context, boolean shouldShowIntroToast) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setANRListener(ANRListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setAppProperties(HashMap<String, String> properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
    }

    public final void setExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Intrinsics.checkNotNullParameter(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    private Pluto() {
    }

    public static /* synthetic */ void initialize$default(Pluto pluto, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        pluto.initialize(context, z);
    }
}
