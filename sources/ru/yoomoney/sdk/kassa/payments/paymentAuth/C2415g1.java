package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.g1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2415g1 extends Lambda implements Function1 {
    public final /* synthetic */ C2326j a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ MutableState c;
    public final /* synthetic */ MutableState d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2415g1(C2326j c2326j, Function1 function1, MutableState mutableState, MutableState mutableState2) {
        super(1);
        this.a = c2326j;
        this.b = function1;
        this.c = mutableState;
        this.d = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String value = (String) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        this.c.setValue("");
        this.d.setValue(value);
        if (value.length() == this.a.b) {
            this.b.invoke(value);
        }
        return Unit.INSTANCE;
    }
}
