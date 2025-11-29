package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function0 {
    public final /* synthetic */ RuntimeViewModel a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(RuntimeViewModel runtimeViewModel, String str) {
        super(0);
        this.a = runtimeViewModel;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.handleAction(new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a(this.b));
        return Unit.INSTANCE;
    }
}
