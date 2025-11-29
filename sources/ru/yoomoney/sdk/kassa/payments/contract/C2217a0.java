package ru.yoomoney.sdk.kassa.payments.contract;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.a0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2217a0 extends Lambda implements Function0 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2217a0(C2264y0 c2264y0) {
        super(0);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("PAYMENT_METHOD_ID")) : null;
        if (numValueOf != null) {
            return numValueOf;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
