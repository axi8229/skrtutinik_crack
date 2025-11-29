package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function0 {
    public final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar) {
        super(0);
        this.a = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        g gVar = this.a;
        int i = g.$r8$clinit;
        gVar.getParentFragmentManager().popBackStack();
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = gVar.b;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.j(null));
        return Unit.INSTANCE;
    }
}
