package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final /* synthetic */ class g extends FunctionReferenceImpl implements Function2 {
    public g(j jVar) {
        super(2, jVar, j.class, "navigateToBankList", "navigateToBankList(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String p0 = (String) obj;
        String p1 = (String) obj2;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        j jVar = (j) this.receiver;
        int i = j.$r8$clinit;
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = jVar.c;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.d(p0, p1));
        return Unit.INSTANCE;
    }
}
