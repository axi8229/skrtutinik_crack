package com.yandex.metrica.identifiers.impl;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class h {
    private final Map a;

    public h(Map providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.a = providers;
    }

    public /* synthetic */ h(Map map, int i) {
        this((i & 1) != 0 ? MapsKt.mapOf(TuplesKt.to("google", new k()), TuplesKt.to("huawei", new r()), TuplesKt.to("yandex", new o())) : null);
    }

    public final Bundle a(Context context, String str) {
        g gVarA;
        Intrinsics.checkNotNullParameter(context, "context");
        i iVar = (i) this.a.get(str);
        if (iVar == null || (gVarA = iVar.a(context)) == null) {
            return null;
        }
        return gVarA.a();
    }
}
