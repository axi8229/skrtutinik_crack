package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.api.InitializationResult;

/* loaded from: classes5.dex */
public final class a0 extends Lambda implements Function1 {
    public static final a0 a = new a0();

    public a0() {
        super(1);
    }

    public static void a(InitializationResult initializationResult) {
        Intrinsics.checkNotNullParameter(initializationResult, "initializationResult");
        ru.yoomoney.sdk.kassa.payments.utils.h.a("init result: " + initializationResult);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((InitializationResult) obj);
        return Unit.INSTANCE;
    }
}
