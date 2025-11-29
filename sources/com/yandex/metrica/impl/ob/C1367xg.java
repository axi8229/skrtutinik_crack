package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.jos.JosConstant;
import com.yandex.metrica.impl.ob.C0877dg;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.xg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1367xg {
    private final Zl<C0877dg.a, Integer> a;
    private final long b;
    private final String c;
    private final String d;
    private final Context e;
    private final C1108mn f;
    private final M0 g;

    /* renamed from: com.yandex.metrica.impl.ob.xg$a */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues((Comparable) ((Pair) t).getSecond(), (Comparable) ((Pair) t2).getSecond());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xg$b */
    static final class b<T> implements Comparator<C0877dg> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(C0877dg c0877dg, C0877dg c0877dg2) {
            int sign = MathKt.getSign(c0877dg.c - c0877dg2.c);
            if (sign != 0) {
                return sign;
            }
            int iIntValue = ((Number) C1367xg.this.a.a(c0877dg.d)).intValue();
            Object objA = C1367xg.this.a.a(c0877dg2.d);
            Intrinsics.checkNotNullExpressionValue(objA, "sourcePriorities[second.source]");
            return iIntValue - ((Number) objA).intValue();
        }
    }

    public C1367xg(Context context, C1108mn c1108mn, M0 m0) {
        this.e = context;
        this.f = c1108mn;
        this.g = m0;
        Zl<C0877dg.a, Integer> zl = new Zl<>(0);
        zl.a(C0877dg.a.HMS, 1);
        zl.a(C0877dg.a.GP, 2);
        this.a = zl;
        this.b = TimeUnit.DAYS.toSeconds(1L);
        this.c = "com.android.vending";
        this.d = JosConstant.APP_MARKET_PACKAGE;
    }

    private final JSONObject c(C0877dg c0877dg) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("referrer", c0877dg.a).put("install_timestamp_seconds", c0877dg.c).put("click_timestamp_seconds", c0877dg.b).put("source", c0877dg.d.a);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …eferrerInfo.source.value)");
        return jSONObjectPut;
    }

    public final boolean b(C0877dg c0877dg) {
        String str = c0877dg != null ? c0877dg.a : null;
        return !(str == null || str.length() == 0);
    }

    public final boolean a(C0877dg c0877dg) {
        String strA;
        if (c0877dg == null) {
            return false;
        }
        C1108mn c1108mn = this.f;
        Context context = this.e;
        String packageName = context.getPackageName();
        c1108mn.getClass();
        try {
            PackageManager packageManager = context.getPackageManager();
            strA = A2.a(30) ? C1133nn.a(packageManager, packageName) : packageManager.getInstallerPackageName(packageName);
        } catch (Throwable unused) {
            strA = null;
        }
        int iOrdinal = c0877dg.d.ordinal();
        if (iOrdinal == 1) {
            return Intrinsics.areEqual(this.c, strA);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return Intrinsics.areEqual(this.d, strA);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C1367xg(Context context, C1108mn c1108mn, M0 m0, int i) {
        M0 m0A = null;
        C1108mn c1108mn2 = (i & 2) != 0 ? new C1108mn() : null;
        if ((i & 4) != 0) {
            m0A = C1152oh.a();
            Intrinsics.checkNotNullExpressionValue(m0A, "YandexMetricaSelfReportFacade.getReporter()");
        }
        this(context, c1108mn2, m0A);
    }

    public final C0877dg a(List<C0877dg> list) {
        C0877dg c0877dg = null;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        C1108mn c1108mn = this.f;
        Context context = this.e;
        PackageInfo packageInfoB = c1108mn.b(context, context.getPackageName(), 0);
        if (packageInfoB != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfoB.firstInstallTime);
            a aVar = new a();
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                C0877dg c0877dg2 = (C0877dg) it.next();
                Pair pair = TuplesKt.to(c0877dg2, Long.valueOf(Math.abs(c0877dg2.c - seconds)));
                while (it.hasNext()) {
                    C0877dg c0877dg3 = (C0877dg) it.next();
                    Pair pair2 = TuplesKt.to(c0877dg3, Long.valueOf(Math.abs(c0877dg3.c - seconds)));
                    if (aVar.compare(pair, pair2) > 0) {
                        pair = pair2;
                    }
                }
                C0877dg c0877dg4 = (C0877dg) pair.component1();
                if (((Number) pair.component2()).longValue() < this.b) {
                    c0877dg = c0877dg4;
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        if (c0877dg == null) {
            b bVar = new b();
            Iterator<T> it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0877dg c0877dg5 = (C0877dg) it2.next();
            while (it2.hasNext()) {
                C0877dg c0877dg6 = (C0877dg) it2.next();
                if (bVar.compare(c0877dg5, c0877dg6) < 0) {
                    c0877dg5 = c0877dg6;
                }
            }
            c0877dg = c0877dg5;
        }
        this.g.reportEvent("several_filled_referrers", a(list, c0877dg, packageInfoB).toString());
        return c0877dg;
    }

    private final JSONObject a(List<C0877dg> list, C0877dg c0877dg, PackageInfo packageInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c((C0877dg) it.next()));
        }
        JSONObject jSONObjectPutOpt = jSONObject.put("candidates", Tl.b((List<?>) arrayList)).put("chosen", c(c0877dg)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPutOpt, "JSONObject()\n           …geInfo?.firstInstallTime)");
        return jSONObjectPutOpt;
    }
}
