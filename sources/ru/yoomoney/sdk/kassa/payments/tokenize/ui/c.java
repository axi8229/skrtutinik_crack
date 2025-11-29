package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;
import ru.yoomoney.sdk.kassa.payments.tokenize.E;
import ru.yoomoney.sdk.kassa.payments.tokenize.F;
import ru.yoomoney.sdk.kassa.payments.tokenize.G;
import ru.yoomoney.sdk.kassa.payments.tokenize.H;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ RuntimeViewModel c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.tokenize.i d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, Context context, RuntimeViewModel runtimeViewModel, ru.yoomoney.sdk.kassa.payments.payment.tokenize.i iVar) {
        super(1);
        this.a = bVar;
        this.b = context;
        this.c = runtimeViewModel;
        this.d = iVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        H it = (H) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter = this.a;
        Context context = this.b;
        b onReload = new b(this.c, this.d);
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        if (it instanceof E) {
            return q.a;
        }
        if (it instanceof F) {
            return new r(((F) it).a);
        }
        if (!(it instanceof G)) {
            throw new NoWhenBranchMatchedException();
        }
        String string = errorFormatter.a(((G) it).b).toString();
        String string2 = context.getString(R$string.ym_retry);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return new s(string, string2, new u(onReload));
    }
}
