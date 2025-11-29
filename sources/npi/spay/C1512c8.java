package npi.spay;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

/* renamed from: npi.spay.c8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1512c8 extends Lambda implements Function0 {
    public final /* synthetic */ OkHttpClient a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1512c8(OkHttpClient okHttpClient) {
        super(0);
        this.a = okHttpClient;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.a;
    }
}
