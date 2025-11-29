package com.sputnik.common.viewmodels;

import android.os.Bundle;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000fR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/common/viewmodels/NavigationAction;", "", "", "dst", "", RemoteMessageConst.MessageBody.PARAM, "Landroid/os/Bundle;", "bundle", "Lcom/sputnik/common/viewmodels/NavigationTypes;", "type", "<init>", "(ILjava/lang/String;Landroid/os/Bundle;Lcom/sputnik/common/viewmodels/NavigationTypes;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDst", "Ljava/lang/String;", "getParam", "setParam", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "Lcom/sputnik/common/viewmodels/NavigationTypes;", "getType", "()Lcom/sputnik/common/viewmodels/NavigationTypes;", "setType", "(Lcom/sputnik/common/viewmodels/NavigationTypes;)V", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NavigationAction {
    private Bundle bundle;
    private final int dst;
    private String param;
    private NavigationTypes type;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigationAction)) {
            return false;
        }
        NavigationAction navigationAction = (NavigationAction) other;
        return this.dst == navigationAction.dst && Intrinsics.areEqual(this.param, navigationAction.param) && Intrinsics.areEqual(this.bundle, navigationAction.bundle) && this.type == navigationAction.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.dst) * 31;
        String str = this.param;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Bundle bundle = this.bundle;
        return ((iHashCode2 + (bundle != null ? bundle.hashCode() : 0)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "NavigationAction(dst=" + this.dst + ", param=" + this.param + ", bundle=" + this.bundle + ", type=" + this.type + ")";
    }

    public NavigationAction(int i, String str, Bundle bundle, NavigationTypes type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.dst = i;
        this.param = str;
        this.bundle = bundle;
        this.type = type;
    }

    public final int getDst() {
        return this.dst;
    }

    public final String getParam() {
        return this.param;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public /* synthetic */ NavigationAction(int i, String str, Bundle bundle, NavigationTypes navigationTypes, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : bundle, (i2 & 8) != 0 ? NavigationTypes.f25default : navigationTypes);
    }

    public final NavigationTypes getType() {
        return this.type;
    }
}
