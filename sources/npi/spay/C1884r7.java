package npi.spay;

import android.content.Context;
import coil.ImageLoader;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.r7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1884r7 {
    public final Context a;
    public final ImageLoader b;

    public C1884r7(Context context, ImageLoader imageLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        this.a = context;
        this.b = imageLoader;
    }
}
