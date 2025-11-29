package npi.spay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.u0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1952u0 {
    public static final boolean a(Context context, String permissionName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(permissionName, "permissionName");
        return context.checkSelfPermission(permissionName) == 0;
    }
}
