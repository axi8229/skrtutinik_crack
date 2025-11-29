package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2386q extends Lambda implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2386q(C2385p c2385p, List list) {
        super(1);
        this.a = c2385p;
        this.b = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return this.a.invoke(this.b.get(((Number) obj).intValue()));
    }
}
