package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.gui.gui.R$dimen;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeConfig;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItemHelper;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.h0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2481h0 extends Lambda implements Function0 {
    public final /* synthetic */ C2487j0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2481h0(C2487j0 c2487j0) {
        super(0);
        this.a = c2487j0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Resources resources = this.a.requireContext().getResources();
        SwipeConfig swipeConfig = SwipeConfig.INSTANCE.get(resources.getInteger(R.integer.config_shortAnimTime), resources.getDimensionPixelSize(R$dimen.ym_space5XL), 1);
        Context contextRequireContext = this.a.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return new SwipeItemHelper(contextRequireContext, swipeConfig);
    }
}
