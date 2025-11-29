package ru.yoomoney.sdk.two_fa.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnumExtension.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0006\u0012\u0002\b\u00030\u0002H\u0080\b¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"mapTo", "T", "", "(Ljava/lang/Enum;)Ljava/lang/Enum;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnumExtensionKt {
    public static final /* synthetic */ <T extends Enum<T>> T mapTo(Enum<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String strName = r2.name();
        Intrinsics.reifiedOperationMarker(5, "T");
        return (T) Enum.valueOf(null, strName);
    }
}
