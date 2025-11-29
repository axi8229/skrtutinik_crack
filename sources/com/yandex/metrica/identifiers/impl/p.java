package com.yandex.metrica.identifiers.impl;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class p {
    private static final Intent a;

    static {
        Intent intent = new Intent("com.yandex.android.advid.IDENTIFIER_SERVICE").setPackage("com.yandex.android.advid");
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(\"com.yandex.andro…om.yandex.android.advid\")");
        a = intent;
    }
}
