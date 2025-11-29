package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.ViewExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2212w extends Lambda implements Function0 {
    public final /* synthetic */ AbstractC2210u a;
    public final /* synthetic */ H b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2212w(AbstractC2210u abstractC2210u, H h) {
        super(0);
        this.a = abstractC2210u;
        this.b = h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AbstractC2210u abstractC2210u = this.a;
        LoadingView loadingView = null;
        if (abstractC2210u instanceof C2209t) {
            H h = this.b;
            LoadingView loadingView2 = h.i;
            if (loadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                loadingView2 = null;
            }
            View childAt = h.a().b.getChildAt(0);
            if (childAt == null) {
                h.a().b.addView(loadingView2);
            } else if (childAt != loadingView2) {
                h.a().b.removeView(childAt);
                h.a().b.addView(loadingView2);
            }
        } else if (abstractC2210u instanceof C2208s) {
            H.a(this.b, ((C2208s) abstractC2210u).a);
        }
        LoadingView loadingView3 = this.b.i;
        if (loadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            loadingView = loadingView3;
        }
        H h2 = this.b;
        ViewGroup.LayoutParams layoutParams = loadingView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        FrameLayout rootContainer = h2.a().b;
        Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
        layoutParams.height = ViewExtensionsKt.getViewHeight(rootContainer);
        loadingView.setLayoutParams(layoutParams);
        return Unit.INSTANCE;
    }
}
