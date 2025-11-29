package com.sputnik.common.viewmodels;

import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/sputnik/common/viewmodels/NavigationScenario;", "", "Lcom/sputnik/common/viewmodels/BottomNavigationAction;", "bottomAction", "Ljava/util/Queue;", "Lcom/sputnik/common/viewmodels/NavigationAction;", "navigationActions", "", "needToPopBackStack", "<init>", "(Lcom/sputnik/common/viewmodels/BottomNavigationAction;Ljava/util/Queue;Z)V", "copy", "(Lcom/sputnik/common/viewmodels/BottomNavigationAction;Ljava/util/Queue;Z)Lcom/sputnik/common/viewmodels/NavigationScenario;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/common/viewmodels/BottomNavigationAction;", "getBottomAction", "()Lcom/sputnik/common/viewmodels/BottomNavigationAction;", "Ljava/util/Queue;", "getNavigationActions", "()Ljava/util/Queue;", "Z", "getNeedToPopBackStack", "()Z", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NavigationScenario {
    private final BottomNavigationAction bottomAction;
    private final Queue<NavigationAction> navigationActions;
    private final boolean needToPopBackStack;

    public NavigationScenario() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NavigationScenario copy$default(NavigationScenario navigationScenario, BottomNavigationAction bottomNavigationAction, Queue queue, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            bottomNavigationAction = navigationScenario.bottomAction;
        }
        if ((i & 2) != 0) {
            queue = navigationScenario.navigationActions;
        }
        if ((i & 4) != 0) {
            z = navigationScenario.needToPopBackStack;
        }
        return navigationScenario.copy(bottomNavigationAction, queue, z);
    }

    public final NavigationScenario copy(BottomNavigationAction bottomAction, Queue<NavigationAction> navigationActions, boolean needToPopBackStack) {
        Intrinsics.checkNotNullParameter(navigationActions, "navigationActions");
        return new NavigationScenario(bottomAction, navigationActions, needToPopBackStack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigationScenario)) {
            return false;
        }
        NavigationScenario navigationScenario = (NavigationScenario) other;
        return Intrinsics.areEqual(this.bottomAction, navigationScenario.bottomAction) && Intrinsics.areEqual(this.navigationActions, navigationScenario.navigationActions) && this.needToPopBackStack == navigationScenario.needToPopBackStack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        BottomNavigationAction bottomNavigationAction = this.bottomAction;
        int iHashCode = (((bottomNavigationAction == null ? 0 : bottomNavigationAction.hashCode()) * 31) + this.navigationActions.hashCode()) * 31;
        boolean z = this.needToPopBackStack;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "NavigationScenario(bottomAction=" + this.bottomAction + ", navigationActions=" + this.navigationActions + ", needToPopBackStack=" + this.needToPopBackStack + ")";
    }

    public NavigationScenario(BottomNavigationAction bottomNavigationAction, Queue<NavigationAction> navigationActions, boolean z) {
        Intrinsics.checkNotNullParameter(navigationActions, "navigationActions");
        this.bottomAction = bottomNavigationAction;
        this.navigationActions = navigationActions;
        this.needToPopBackStack = z;
    }

    public final BottomNavigationAction getBottomAction() {
        return this.bottomAction;
    }

    public /* synthetic */ NavigationScenario(BottomNavigationAction bottomNavigationAction, Queue queue, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bottomNavigationAction, (i & 2) != 0 ? new LinkedList() : queue, (i & 4) != 0 ? false : z);
    }

    public final Queue<NavigationAction> getNavigationActions() {
        return this.navigationActions;
    }

    public final boolean getNeedToPopBackStack() {
        return this.needToPopBackStack;
    }
}
