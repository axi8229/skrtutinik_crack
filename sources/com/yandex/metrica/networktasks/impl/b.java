package com.yandex.metrica.networktasks.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b {
    private final String a;

    public b(String str) {
        this.a = a(str);
    }

    private final String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Uri uri = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return Intrinsics.areEqual("http", uri.getScheme()) ? uri.buildUpon().scheme("https").build().toString() : str;
    }

    public final String a() {
        return this.a;
    }
}
