package com.sputnik.common.di;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* compiled from: CommonComponent.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/di/CommonComponentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "commonComponent", "Lcom/sputnik/common/di/CommonComponent;", "getCommonComponent", "()Lcom/sputnik/common/di/CommonComponent;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommonComponentViewModel extends ViewModel {
    private final CommonComponent commonComponent = DaggerCommonComponent.builder().deps(CommonDepsProvider.INSTANCE.getDeps()).build();

    public final CommonComponent getCommonComponent() {
        return this.commonComponent;
    }
}
