package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes5.dex */
public final class W extends Lambda implements Function2 {
    public final /* synthetic */ C2487j0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(C2487j0 c2487j0) {
        super(2);
        this.a = c2487j0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Bundle bundle = (Bundle) obj2;
        Intrinsics.checkNotNullParameter((String) obj, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Parcelable parcelable = bundle.getParcelable("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.UNBIND_CARD_RESULT_EXTRA");
        if (parcelable == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireNotNull(...)");
        C2487j0 c2487j0 = this.a;
        String str = ((ru.yoomoney.sdk.kassa.payments.navigation.s) parcelable).a;
        int i = C2487j0.$r8$clinit;
        View view = c2487j0.getView();
        if (view != null) {
            String string = c2487j0.getString(R$string.ym_unbinding_card_success, StringsKt.takeLast(str, 4));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ru.yoomoney.sdk.kassa.payments.extensions.l.a(view, string, R$color.color_type_inverse, R$color.color_type_success);
        }
        return Unit.INSTANCE;
    }
}
