package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2387s extends Lambda implements Function1 {
    public final /* synthetic */ List a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2387s(List list, Function1 function1, Function0 function0) {
        super(1);
        this.a = list;
        this.b = function1;
        this.c = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        LazyListScope LazyColumn = (LazyListScope) obj;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        List list = this.a;
        Function1 function1 = this.b;
        Function0 function0 = this.c;
        LazyColumn.items(list.size(), null, new C2386q(C2385p.a, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new r(list, function1, function0)));
        return Unit.INSTANCE;
    }
}
