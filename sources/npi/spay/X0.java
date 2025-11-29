package npi.spay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class X0 {
    public final zone.bi.mobile.sdk.e a;

    public X0(Context context, G2 settings, zone.bi.mobile.sdk.b dependencies) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        zone.bi.mobile.sdk.e eVarA = new zone.bi.mobile.sdk.a(context, settings, dependencies).a(this).a();
        Intrinsics.checkNotNullExpressionValue(eVarA, "BmsSdkBuilder(context, s…itListener(this).create()");
        this.a = eVarA;
    }
}
