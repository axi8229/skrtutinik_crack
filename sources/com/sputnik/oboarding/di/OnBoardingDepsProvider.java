package com.sputnik.oboarding.di;

import kotlin.Metadata;

/* compiled from: OnBoardingDeps.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/sputnik/oboarding/di/OnBoardingDepsProvider;", "", "Companion", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OnBoardingDepsProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: OnBoardingDeps.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048WX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/oboarding/di/OnBoardingDepsProvider$Companion;", "Lcom/sputnik/oboarding/di/OnBoardingDepsProvider;", "()V", "deps", "Lcom/sputnik/oboarding/di/OnBoardingDeps;", "getDeps", "()Lcom/sputnik/oboarding/di/OnBoardingDeps;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements OnBoardingDepsProvider {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private final /* synthetic */ OnBoardingDepsStore $$delegate_0 = OnBoardingDepsStore.INSTANCE;

        public OnBoardingDeps getDeps() {
            return this.$$delegate_0.getDeps();
        }

        private Companion() {
        }
    }
}
