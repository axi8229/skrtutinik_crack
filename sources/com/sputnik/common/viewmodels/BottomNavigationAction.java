package com.sputnik.common.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/sputnik/common/viewmodels/BottomNavigationAction;", "", "", "deeplink", "", "deeplinkInt", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeeplink", "Ljava/lang/Integer;", "getDeeplinkInt", "()Ljava/lang/Integer;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BottomNavigationAction {
    private final String deeplink;
    private final Integer deeplinkInt;

    public BottomNavigationAction() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomNavigationAction)) {
            return false;
        }
        BottomNavigationAction bottomNavigationAction = (BottomNavigationAction) other;
        return Intrinsics.areEqual(this.deeplink, bottomNavigationAction.deeplink) && Intrinsics.areEqual(this.deeplinkInt, bottomNavigationAction.deeplinkInt);
    }

    public int hashCode() {
        String str = this.deeplink;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.deeplinkInt;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "BottomNavigationAction(deeplink=" + this.deeplink + ", deeplinkInt=" + this.deeplinkInt + ")";
    }

    public BottomNavigationAction(String str, Integer num) {
        this.deeplink = str;
        this.deeplinkInt = num;
    }

    public /* synthetic */ BottomNavigationAction(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }

    public final Integer getDeeplinkInt() {
        return this.deeplinkInt;
    }
}
