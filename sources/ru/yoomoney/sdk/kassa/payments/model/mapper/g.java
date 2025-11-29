package ru.yoomoney.sdk.kassa.payments.model.mapper;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.ConfirmationType;

/* loaded from: classes5.dex */
public abstract class g {
    public static final ConfirmationType a(ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.ConfirmationType confirmationType) {
        Intrinsics.checkNotNullParameter(confirmationType, "<this>");
        int i = f.a[confirmationType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? ConfirmationType.UNKNOWN : ConfirmationType.MOBILE_APPLICATION : ConfirmationType.REDIRECT : ConfirmationType.EXTERNAL;
    }
}
