package ru.yoomoney.sdk.kassa.payments.logout;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.extensions.k;
import ru.yoomoney.sdk.kassa.payments.model.C2318b;
import ru.yoomoney.sdk.kassa.payments.secure.j;

/* loaded from: classes5.dex */
public final class d implements c {
    public final a a;

    public d(a logoutRepository) {
        Intrinsics.checkNotNullParameter(logoutRepository, "logoutRepository");
        this.a = logoutRepository;
    }

    public final Unit a() {
        b bVar = (b) this.a;
        String strE = ((j) bVar.b).e();
        k.a(((j) bVar.b).a, "yooUserUID", null);
        k.a(((j) bVar.b).a, "yooUserAuthToken", null);
        k.a(((j) bVar.b).a, "yooUserAuthName", null);
        k.a(((j) bVar.b).a, "userAuthToken", null);
        bVar.c.a((String) null);
        bVar.e.a = null;
        bVar.a.a(C2318b.a);
        bVar.f.invoke();
        ((ru.yoomoney.sdk.kassa.payments.payment.d) bVar.d).a = false;
        bVar.g.invoke(strE);
        Unit unit = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return unit;
    }
}
