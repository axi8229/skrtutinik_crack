package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.SubscriptionInfo;
import com.yandex.metrica.DoNotInline;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yandex/metrica/impl/ob/Wj;", "", "Landroid/telephony/SubscriptionInfo;", "subscriptionInfo", "", "a", "(Landroid/telephony/SubscriptionInfo;)Ljava/lang/Integer;", "b", "<init>", "()V", "mobmetricalib_publicBinaryProdRelease"}, k = 1, mv = {1, 1, 15})
@TargetApi(29)
@DoNotInline
/* loaded from: classes3.dex */
public final class Wj {
    public static final Wj a = new Wj();

    private Wj() {
    }

    @JvmStatic
    public static final Integer a(SubscriptionInfo subscriptionInfo) {
        return C0810b.c(subscriptionInfo.getMccString());
    }

    @JvmStatic
    public static final Integer b(SubscriptionInfo subscriptionInfo) {
        return C0810b.c(subscriptionInfo.getMncString());
    }
}
