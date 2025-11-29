package com.yandex.varioqub.config.impl;

import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes3.dex */
public abstract class D {
    public static String a;

    public static String a(String str) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = a;
        if (str2 == null) {
            str2 = "https://app.uaas.yandex.ru/v1/app?client_id=%s";
        }
        return String.format(str2, Arrays.copyOf(new Object[]{str}, 1));
    }
}
