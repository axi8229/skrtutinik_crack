package com.yandex.metrica.impl.ob;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.t2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1257t2 extends V1<String[]> {
    public C1257t2(Context context, String str) {
        super(context, str, "array");
    }

    @Override // com.yandex.metrica.impl.ob.V1
    public String[] a(int i) {
        Context mContext = this.a;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        return mContext.getResources().getStringArray(i);
    }
}
