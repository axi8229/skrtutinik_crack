package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ RuntimeViewModel c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, Context context, RuntimeViewModel runtimeViewModel, String str) {
        super(1);
        this.a = bVar;
        this.b = context;
        this.c = runtimeViewModel;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ru.yoomoney.sdk.kassa.payments.confirmation.sbp.l it = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.l) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter = this.a;
        Context context = this.b;
        b onReload = new b(this.c, this.d);
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        if (it instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j) {
            return p.a;
        }
        if (!(it instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.k)) {
            throw new NoWhenBranchMatchedException();
        }
        String string = errorFormatter.a(((ru.yoomoney.sdk.kassa.payments.confirmation.sbp.k) it).a).toString();
        String string2 = context.getString(R$string.ym_retry);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return new o(string, string2, onReload);
    }
}
