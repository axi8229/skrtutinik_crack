package com.yandex.metrica.impl.ob;

import java.lang.reflect.Field;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* renamed from: com.yandex.metrica.impl.ob.f3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0914f3 {
    @JvmStatic
    public static final com.yandex.metrica.billing_interface.b a() {
        String str;
        Field field;
        try {
            Class clsB = C0963h2.b("com.android.billingclient.BuildConfig");
            str = (String) ((clsB == null || (field = clsB.getField("VERSION_NAME")) == null) ? null : field.get(null));
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            return com.yandex.metrica.billing_interface.b.NONE;
        }
        if (!StringsKt.startsWith$default(str, "2.", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "3.", false, 2, (Object) null)) {
            return StringsKt.startsWith$default(str, "4.", false, 2, (Object) null) ? com.yandex.metrica.billing_interface.b.LIBRARY_V4 : com.yandex.metrica.billing_interface.b.LIBRARY_V4;
        }
        return com.yandex.metrica.billing_interface.b.LIBRARY_V3;
    }
}
