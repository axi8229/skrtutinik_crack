package com.yandex.metrica.identifiers.impl;

import android.os.IBinder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
final class n extends Lambda implements Function1 {
    public static final n a = new n();

    n() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        IBinder it = (IBinder) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        c cVarA = b.a(it);
        Intrinsics.checkNotNullExpressionValue(cVarA, "YandexAdvIdInterface.Stub.asInterface(it)");
        return cVarA;
    }
}
