package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.pm.ResolveInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function1 {
    public static final f a = new f();

    public f() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ResolveInfo) obj).activityInfo;
    }
}
