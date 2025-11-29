package com.yandex.metrica.identifiers.impl;

import android.os.IBinder;
import android.os.IInterface;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
final class q extends Lambda implements Function1 {
    public static final q a = new q();

    q() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        v tVar;
        IBinder it = (IBinder) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = u.$r8$clinit;
        if (it == null) {
            tVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = it.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            tVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof v)) ? new t(it) : (v) iInterfaceQueryLocalInterface;
        }
        Intrinsics.checkNotNullExpressionValue(tVar, "OpenDeviceIdentifierService.Stub.asInterface(it)");
        return tVar;
    }
}
