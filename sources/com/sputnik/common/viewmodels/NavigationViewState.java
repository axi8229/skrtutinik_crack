package com.sputnik.common.viewmodels;

import com.sputnik.common.base.VMState;
import com.sputnik.domain.common.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/viewmodels/NavigationViewState;", "Lcom/sputnik/common/base/VMState;", "Lcom/sputnik/common/viewmodels/NavigationScenario;", "action", "Lcom/sputnik/domain/common/Event;", "Lcom/sputnik/common/viewmodels/BottomNavigationAction;", "bottomMenuNavigationAction", "", "needToHideBottomMenu", "needClearActivityIntent", "<init>", "(Lcom/sputnik/common/viewmodels/NavigationScenario;Lcom/sputnik/domain/common/Event;ZZ)V", "copy", "(Lcom/sputnik/common/viewmodels/NavigationScenario;Lcom/sputnik/domain/common/Event;ZZ)Lcom/sputnik/common/viewmodels/NavigationViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/viewmodels/NavigationScenario;", "getAction", "()Lcom/sputnik/common/viewmodels/NavigationScenario;", "Lcom/sputnik/domain/common/Event;", "getBottomMenuNavigationAction", "()Lcom/sputnik/domain/common/Event;", "Z", "getNeedToHideBottomMenu", "()Z", "getNeedClearActivityIntent", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NavigationViewState implements VMState {
    private final NavigationScenario action;
    private final Event<BottomNavigationAction> bottomMenuNavigationAction;
    private final boolean needClearActivityIntent;
    private final boolean needToHideBottomMenu;

    public NavigationViewState() {
        this(null, null, false, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NavigationViewState copy$default(NavigationViewState navigationViewState, NavigationScenario navigationScenario, Event event, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            navigationScenario = navigationViewState.action;
        }
        if ((i & 2) != 0) {
            event = navigationViewState.bottomMenuNavigationAction;
        }
        if ((i & 4) != 0) {
            z = navigationViewState.needToHideBottomMenu;
        }
        if ((i & 8) != 0) {
            z2 = navigationViewState.needClearActivityIntent;
        }
        return navigationViewState.copy(navigationScenario, event, z, z2);
    }

    public final NavigationViewState copy(NavigationScenario action, Event<BottomNavigationAction> bottomMenuNavigationAction, boolean needToHideBottomMenu, boolean needClearActivityIntent) {
        Intrinsics.checkNotNullParameter(bottomMenuNavigationAction, "bottomMenuNavigationAction");
        return new NavigationViewState(action, bottomMenuNavigationAction, needToHideBottomMenu, needClearActivityIntent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigationViewState)) {
            return false;
        }
        NavigationViewState navigationViewState = (NavigationViewState) other;
        return Intrinsics.areEqual(this.action, navigationViewState.action) && Intrinsics.areEqual(this.bottomMenuNavigationAction, navigationViewState.bottomMenuNavigationAction) && this.needToHideBottomMenu == navigationViewState.needToHideBottomMenu && this.needClearActivityIntent == navigationViewState.needClearActivityIntent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        NavigationScenario navigationScenario = this.action;
        int iHashCode = (((navigationScenario == null ? 0 : navigationScenario.hashCode()) * 31) + this.bottomMenuNavigationAction.hashCode()) * 31;
        boolean z = this.needToHideBottomMenu;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z2 = this.needClearActivityIntent;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "NavigationViewState(action=" + this.action + ", bottomMenuNavigationAction=" + this.bottomMenuNavigationAction + ", needToHideBottomMenu=" + this.needToHideBottomMenu + ", needClearActivityIntent=" + this.needClearActivityIntent + ")";
    }

    public NavigationViewState(NavigationScenario navigationScenario, Event<BottomNavigationAction> bottomMenuNavigationAction, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(bottomMenuNavigationAction, "bottomMenuNavigationAction");
        this.action = navigationScenario;
        this.bottomMenuNavigationAction = bottomMenuNavigationAction;
        this.needToHideBottomMenu = z;
        this.needClearActivityIntent = z2;
    }

    public final NavigationScenario getAction() {
        return this.action;
    }

    public /* synthetic */ NavigationViewState(NavigationScenario navigationScenario, Event event, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : navigationScenario, (i & 2) != 0 ? new Event(new BottomNavigationAction(null, null, 3, null)) : event, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final boolean getNeedToHideBottomMenu() {
        return this.needToHideBottomMenu;
    }

    public final boolean getNeedClearActivityIntent() {
        return this.needClearActivityIntent;
    }
}
