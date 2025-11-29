package com.group_ib.sdk;

import android.telephony.TelephonyManager$CellInfoCallback;
import java.util.List;

/* renamed from: com.group_ib.sdk.s0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0620s0 extends TelephonyManager$CellInfoCallback {
    public final /* synthetic */ C0628w0 a;

    public C0620s0(C0628w0 c0628w0) {
        this.a = c0628w0;
    }

    public final void onCellInfo(List list) {
        this.a.a(list);
    }
}
