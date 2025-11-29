package com.yandex.metrica.impl.ob;

import android.content.Context;
import kotlin.jvm.JvmStatic;

/* renamed from: com.yandex.metrica.impl.ob.vd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1316vd {
    @JvmStatic
    public static final boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
