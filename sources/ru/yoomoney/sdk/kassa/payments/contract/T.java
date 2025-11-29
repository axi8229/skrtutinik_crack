package ru.yoomoney.sdk.kassa.payments.contract;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class T extends Lambda implements Function0 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(C2264y0 c2264y0) {
        super(0);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        if (arguments != null) {
            return arguments.getString("INSTRUMENT_ID");
        }
        return null;
    }
}
