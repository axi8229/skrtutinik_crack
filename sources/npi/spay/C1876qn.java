package npi.spay;

import android.content.Context;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.qn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1876qn {
    public final Context a;

    public C1876qn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    public final String a(int i, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return AbstractC1550dl.a(AbstractC1550dl.a(i, Arrays.copyOf(args, args.length)), this.a);
    }
}
