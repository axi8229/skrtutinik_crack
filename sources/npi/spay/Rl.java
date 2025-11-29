package npi.spay;

import android.content.Context;
import bz.C0515g0;
import bz.C0527k0;
import bz.C0555t1;
import bz.C0557u0;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* loaded from: classes4.dex */
public final class Rl {
    public static C0555t1 a(Context context, final OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        C0557u0 c0557u0 = (C0557u0) Preconditions.checkNotNull(new C0557u0((Context) Preconditions.checkNotNull((Context) ((C0527k0) ((C0515g0) ((bz.L) new X0(context, new G2(context), new zone.bi.mobile.sdk.b() { // from class: npi.spay.Rl$$ExternalSyntheticLambda0
        }).a.a.b.a(bz.L.class))).a).b.get(), "Cannot return null from a non-@Nullable component method")), "Cannot return null from a non-@Nullable @Provides method");
        Intrinsics.checkNotNullExpressionValue(c0557u0, "bmsSdk.apiProvider.fingerprintApi");
        C0555t1 c0555t1 = new C0555t1(c0557u0.a);
        Intrinsics.checkNotNullExpressionValue(c0555t1, "fingerprintApi.fingerprintSdkFactory");
        return c0555t1;
    }
}
