package ru.yoomoney.sdk.kassa.payments.model.mapper;

import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.ConfirmationType;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ConfirmationType.values().length];
        try {
            iArr[ConfirmationType.EXTERNAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ConfirmationType.REDIRECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[ConfirmationType.MOBILE_APPLICATION.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        a = iArr;
    }
}
