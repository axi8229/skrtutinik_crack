package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C2344c;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2372c extends Lambda implements Function2 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 a;
    public final /* synthetic */ RuntimeViewModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2372c(ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 d0Var, RuntimeViewModel runtimeViewModel) {
        super(2);
        this.a = d0Var;
        this.b = runtimeViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Lifecycle.Event event = (Lifecycle.Event) obj2;
        Intrinsics.checkNotNullParameter((LifecycleOwner) obj, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME && ((j0) this.a).c) {
            this.b.handleAction(C2344c.a);
        }
        return Unit.INSTANCE;
    }
}
