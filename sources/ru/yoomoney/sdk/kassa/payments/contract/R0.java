package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes5.dex */
public abstract class R0 {
    public static final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getString(R$string.ym_agent_scheme_default_part_1) + context.getString(R$string.ym_agent_scheme_default_part_2);
    }
}
