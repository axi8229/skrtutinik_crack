package ru.yoomoney.sdk.kassa.payments.contract;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.g0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2229g0 extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.model.Q b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2229g0(C2264y0 c2264y0, ru.yoomoney.sdk.kassa.payments.model.Q q) {
        super(1);
        this.a = c2264y0;
        this.b = q;
    }

    public final void a(final String cvc) {
        Intrinsics.checkNotNullParameter(cvc, "cvc");
        C2264y0 c2264y0 = this.a;
        int i = C2264y0.$r8$clinit;
        c2264y0.a().k.setEnabled(true);
        PrimaryButtonView primaryButtonView = this.a.a().k;
        final C2264y0 c2264y02 = this.a;
        final ru.yoomoney.sdk.kassa.payments.model.Q q = this.b;
        primaryButtonView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.kassa.payments.contract.g0$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2229g0.a(c2264y02, q, cvc, view);
            }
        });
        View view = this.a.getView();
        if (view != null) {
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.INSTANCE;
    }

    public static final void a(C2264y0 this$0, ru.yoomoney.sdk.kassa.payments.model.Q instrumentBankCard, String cvc, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instrumentBankCard, "$instrumentBankCard");
        Intrinsics.checkNotNullParameter(cvc, "$cvc");
        C2264y0.a(this$0).handleAction(new C2234j(instrumentBankCard, cvc));
    }
}
