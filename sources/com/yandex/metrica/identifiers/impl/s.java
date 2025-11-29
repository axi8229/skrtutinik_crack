package com.yandex.metrica.identifiers.impl;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class s {
    private static final Intent a;

    static {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(\"com.uodis.opende…ackage(\"com.huawei.hwid\")");
        a = intent;
    }
}
