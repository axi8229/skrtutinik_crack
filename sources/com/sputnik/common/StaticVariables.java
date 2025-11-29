package com.sputnik.common;

import com.sputnik.common.entities.promotion.ScreenVariants;
import kotlin.Metadata;

/* compiled from: StaticVariables.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/StaticVariables;", "", "()V", "customScenarioEnabled", "", "getCustomScenarioEnabled", "()Z", "setCustomScenarioEnabled", "(Z)V", "navigationClickMethod", "Lcom/sputnik/common/entities/promotion/ScreenVariants;", "getNavigationClickMethod", "()Lcom/sputnik/common/entities/promotion/ScreenVariants;", "setNavigationClickMethod", "(Lcom/sputnik/common/entities/promotion/ScreenVariants;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StaticVariables {
    public static final StaticVariables INSTANCE = new StaticVariables();
    private static boolean customScenarioEnabled;
    private static ScreenVariants navigationClickMethod;

    private StaticVariables() {
    }

    public final ScreenVariants getNavigationClickMethod() {
        return navigationClickMethod;
    }

    public final void setNavigationClickMethod(ScreenVariants screenVariants) {
        navigationClickMethod = screenVariants;
    }

    public final boolean getCustomScenarioEnabled() {
        return customScenarioEnabled;
    }

    public final void setCustomScenarioEnabled(boolean z) {
        customScenarioEnabled = z;
    }
}
