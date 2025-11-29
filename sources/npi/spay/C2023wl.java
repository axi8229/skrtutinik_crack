package npi.spay;

import android.content.Context;
import android.os.LocaleList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.wl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2023wl {
    public final Context a;
    public final InterfaceC1532d3 b;
    public final B2 c;
    public final Lazy d;
    public String e;

    public C2023wl(Context appContext, W3 deviceIdProvider, B2 sessionProvider) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        this.a = appContext;
        this.b = deviceIdProvider;
        this.c = sessionProvider;
        this.d = LazyKt.lazy(new Vk(this));
        this.e = "";
    }

    public static final String a(C2023wl c2023wl) {
        LocaleList locales = c2023wl.a.getResources().getConfiguration().getLocales();
        String language = locales.isEmpty() ? "UNKNOWN" : locales.get(0).getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "appContext.resources.con…e\n            }\n        }");
        return language;
    }
}
