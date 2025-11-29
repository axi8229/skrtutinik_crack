package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import com.yandex.metrica.DoNotInline;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/yandex/metrica/impl/ob/Vj;", "", "Landroid/content/Context;", "context", "", "Lcom/yandex/metrica/impl/ob/Tj;", "a", "(Landroid/content/Context;)Ljava/util/List;", "<init>", "()V", "mobmetricalib_publicBinaryProdRelease"}, k = 1, mv = {1, 1, 15})
@TargetApi(23)
@DoNotInline
/* loaded from: classes3.dex */
public final class Vj {
    public static final Vj a = new Vj();

    static final class a<T, R> implements InterfaceC1157om<SubscriptionManager, List<? extends SubscriptionInfo>> {
        public static final a a = new a();

        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1157om
        public List<? extends SubscriptionInfo> a(SubscriptionManager subscriptionManager) {
            return subscriptionManager.getActiveSubscriptionInfoList();
        }
    }

    private Vj() {
    }

    @JvmStatic
    public static final List<Tj> a(Context context) {
        List<SubscriptionInfo> list = (List) A2.a(a.a, context, "telephony_subscription_service", "getting active subcription info list", "SubscriptionManager");
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SubscriptionInfo subscriptionInfo : list) {
            Integer numA = A2.a(29) ? Wj.a(subscriptionInfo) : Integer.valueOf(subscriptionInfo.getMcc());
            Integer numB = A2.a(29) ? Wj.b(subscriptionInfo) : Integer.valueOf(subscriptionInfo.getMnc());
            boolean z = subscriptionInfo.getDataRoaming() == 1;
            CharSequence carrierName = subscriptionInfo.getCarrierName();
            arrayList.add(new Tj(numA, numB, z, carrierName != null ? carrierName.toString() : null));
        }
        return arrayList;
    }
}
