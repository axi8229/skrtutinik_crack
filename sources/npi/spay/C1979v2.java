package npi.spay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.RedirectActivity;

/* renamed from: npi.spay.v2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1979v2 extends Lambda implements Function1 {
    public final /* synthetic */ Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1979v2(Context context) {
        super(1);
        this.a = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("spaysdk://payment"), this.a, RedirectActivity.class));
        return Unit.INSTANCE;
    }
}
