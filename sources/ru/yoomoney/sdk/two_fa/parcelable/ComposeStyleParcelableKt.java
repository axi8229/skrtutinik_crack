package ru.yoomoney.sdk.two_fa.parcelable;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* compiled from: ComposeStyleParcelable.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"readULong", "Lkotlin/ULong;", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)J", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposeStyleParcelableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long readULong(Parcel parcel) {
        String string = parcel.readString();
        if (string == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(string, "checkNotNull(...)");
        return UStringsKt.toULong(string);
    }
}
