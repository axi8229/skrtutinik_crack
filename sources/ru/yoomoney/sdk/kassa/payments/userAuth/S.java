package ru.yoomoney.sdk.kassa.payments.userAuth;

import android.content.Intent;
import android.net.Uri;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;

/* loaded from: classes5.dex */
public final class S extends Lambda implements Function0 {
    public final /* synthetic */ T a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(T t) {
        super(0);
        this.a = t;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PaymentParameters paymentParameters = this.a.c;
        if (paymentParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentParameters");
            paymentParameters = null;
        }
        String authCenterClientId = paymentParameters.getAuthCenterClientId();
        if (authCenterClientId == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        List scopes = CollectionsKt.listOf((Object[]) new AuxTokenScope[]{AuxTokenScope.Wallet.Balance.INSTANCE, AuxTokenScope.UserAuthCenter.AccountInfo.INSTANCE});
        Intrinsics.checkNotNullParameter(authCenterClientId, "authCenterClientId");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        return new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("yoomoney").authority("auxtoken").path("/issue").appendQueryParameter("authCenterClientId", authCenterClientId).appendQueryParameter("scopes", CollectionsKt.joinToString$default(scopes, ",", null, null, 0, null, null, 62, null)).build());
    }
}
