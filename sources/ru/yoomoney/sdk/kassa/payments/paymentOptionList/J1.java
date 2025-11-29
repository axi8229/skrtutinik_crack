package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem;

/* loaded from: classes5.dex */
public final class J1 extends RecyclerView.ViewHolder implements SwipeItem.Presenter {
    public final C2507r0 a;
    public boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J1(C2507r0 view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.Presenter
    public final View getContentContainer() {
        return this.a.getContentContainer();
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.Presenter
    public final View getSwipeMenuContainer() {
        return this.a.getSwipeMenuContainer();
    }

    @Override // ru.yoomoney.sdk.kassa.payments.ui.swipe.SwipeItem.Presenter
    public final boolean isSwipeAvailable() {
        return this.b;
    }
}
