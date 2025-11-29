package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.h1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2418h1 extends Lambda implements Function0 {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ MutableState b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2418h1(Function0 function0, MutableState mutableState) {
        super(0);
        this.a = function0;
        this.b = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.invoke();
        this.b.setValue("");
        return Unit.INSTANCE;
    }
}
