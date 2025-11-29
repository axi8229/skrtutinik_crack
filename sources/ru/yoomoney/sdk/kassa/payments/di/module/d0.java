package ru.yoomoney.sdk.kassa.payments.di.module;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class d0 extends Lambda implements Function0 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.secure.i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(ru.yoomoney.sdk.kassa.payments.secure.i iVar) {
        super(0);
        this.a = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.a.b();
    }
}
