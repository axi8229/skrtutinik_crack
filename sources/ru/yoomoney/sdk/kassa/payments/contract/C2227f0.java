package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.f0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2227f0 extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2227f0(C2264y0 c2264y0) {
        super(1);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intent it = (Intent) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.startActivityForResult(it, 14269);
        return Unit.INSTANCE;
    }
}
