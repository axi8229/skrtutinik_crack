package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.subscriptions.BaseSubscription;
import kotlin.Metadata;

/* compiled from: SubscriptionsViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/common/viewmodels/SubscriptionsInfo;", "", "()V", "activeSubscription", "Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "getActiveSubscription", "()Lcom/sputnik/common/entities/subscriptions/BaseSubscription;", "setActiveSubscription", "(Lcom/sputnik/common/entities/subscriptions/BaseSubscription;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscriptionsInfo {
    public static final SubscriptionsInfo INSTANCE = new SubscriptionsInfo();
    private static BaseSubscription activeSubscription;

    private SubscriptionsInfo() {
    }

    public final BaseSubscription getActiveSubscription() {
        return activeSubscription;
    }

    public final void setActiveSubscription(BaseSubscription baseSubscription) {
        activeSubscription = baseSubscription;
    }
}
