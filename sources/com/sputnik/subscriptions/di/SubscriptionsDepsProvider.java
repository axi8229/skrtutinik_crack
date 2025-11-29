package com.sputnik.subscriptions.di;

import kotlin.Metadata;

/* compiled from: SubscriptionsDeps.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/subscriptions/di/SubscriptionsDepsProvider;", "", "Companion", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SubscriptionsDepsProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: SubscriptionsDeps.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048WX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/subscriptions/di/SubscriptionsDepsProvider$Companion;", "Lcom/sputnik/subscriptions/di/SubscriptionsDepsProvider;", "()V", "deps", "Lcom/sputnik/subscriptions/di/SubscriptionsDeps;", "getDeps", "()Lcom/sputnik/subscriptions/di/SubscriptionsDeps;", "subscriptions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements SubscriptionsDepsProvider {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private final /* synthetic */ SubscriptionsDepsStore $$delegate_0 = SubscriptionsDepsStore.INSTANCE;

        public SubscriptionsDeps getDeps() {
            return this.$$delegate_0.getDeps();
        }

        private Companion() {
        }
    }
}
