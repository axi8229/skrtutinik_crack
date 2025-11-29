package npi.spay;

import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class M0 {
    public static int a(Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        return resources.getColor(i, null);
    }
}
