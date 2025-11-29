package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import com.yandex.metrica.DoNotInline;
import com.yandex.metrica.impl.ob.C1398z;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/yandex/metrica/impl/ob/y;", "", "Landroid/content/Context;", "context", "Lcom/yandex/metrica/impl/ob/v;", "converter", "Lcom/yandex/metrica/impl/ob/z;", "a", "(Landroid/content/Context;Lcom/yandex/metrica/impl/ob/v;)Lcom/yandex/metrica/impl/ob/z;", "<init>", "()V", "mobmetricalib_publicBinaryProdRelease"}, k = 1, mv = {1, 1, 15})
@TargetApi(28)
@DoNotInline
/* renamed from: com.yandex.metrica.impl.ob.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1374y {
    public static final C1374y a = new C1374y();

    /* renamed from: com.yandex.metrica.impl.ob.y$a */
    static final class a<T, R> implements InterfaceC1157om<UsageStatsManager, C1398z.a> {
        final /* synthetic */ C1302v a;

        a(C1302v c1302v) {
            this.a = c1302v;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1157om
        public C1398z.a a(UsageStatsManager usageStatsManager) {
            C1302v c1302v = this.a;
            int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
            c1302v.getClass();
            if (A2.a(28)) {
                if (A2.a(30) && appStandbyBucket == 45) {
                    return C1398z.a.RESTRICTED;
                }
                if (appStandbyBucket == 10) {
                    return C1398z.a.ACTIVE;
                }
                if (appStandbyBucket == 20) {
                    return C1398z.a.WORKING_SET;
                }
                if (appStandbyBucket == 30) {
                    return C1398z.a.FREQUENT;
                }
                if (appStandbyBucket == 40) {
                    return C1398z.a.RARE;
                }
            }
            return null;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.y$b */
    static final class b<T, R> implements InterfaceC1157om<ActivityManager, Boolean> {
        public static final b a = new b();

        b() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1157om
        public Boolean a(ActivityManager activityManager) {
            return Boolean.valueOf(activityManager.isBackgroundRestricted());
        }
    }

    private C1374y() {
    }

    @JvmStatic
    public static final C1398z a(Context context, C1302v converter) {
        return new C1398z((C1398z.a) A2.a(new a(converter), context, "usagestats", "getting app standby bucket", "usageStatsManager"), (Boolean) A2.a(b.a, context, "activity", "getting is background restricted", "activityManager"));
    }
}
