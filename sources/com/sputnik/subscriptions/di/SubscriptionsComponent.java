package com.sputnik.subscriptions.di;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sputnik.subscriptions.ui.sheets.BottomSheetAboutService;
import com.sputnik.subscriptions.ui.sheets.BottomSheetSuccessPayment;
import kotlin.Metadata;

/* compiled from: SubscriptionsComponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/sputnik/subscriptions/di/SubscriptionsComponent;", "", "inject", "", "bottomSheet", "Lcom/sputnik/subscriptions/ui/sheets/BottomSheetAboutService;", "Lcom/sputnik/subscriptions/ui/sheets/BottomSheetSuccessPayment;", "Builder", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SubscriptionsComponent {

    /* compiled from: SubscriptionsComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/sputnik/subscriptions/di/SubscriptionsComponent$Builder;", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/sputnik/subscriptions/di/SubscriptionsComponent;", "deps", "Lcom/sputnik/subscriptions/di/SubscriptionsDeps;", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        SubscriptionsComponent build();

        Builder deps(SubscriptionsDeps deps);
    }

    void inject(BottomSheetAboutService bottomSheet);

    void inject(BottomSheetSuccessPayment bottomSheet);
}
