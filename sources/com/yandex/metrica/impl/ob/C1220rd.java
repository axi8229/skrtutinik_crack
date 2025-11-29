package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.network.UserAgent;
import com.yandex.metrica.networktasks.api.ConfigProvider;
import com.yandex.metrica.networktasks.api.DefaultNetworkResponseHandler;
import com.yandex.metrica.networktasks.api.ExponentialBackoffDataHolder;
import com.yandex.metrica.networktasks.api.FullUrlFormer;
import com.yandex.metrica.networktasks.api.NetworkTask;
import com.yandex.metrica.networktasks.api.RequestDataHolder;
import com.yandex.metrica.networktasks.api.ResponseDataHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.rd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1220rd {
    public static final C1220rd c = new C1220rd();
    private static final Map<EnumC1197qd, ExponentialBackoffDataHolder> a = new LinkedHashMap();
    private static final String b = UserAgent.getFor("com.yandex.mobile.metrica.sdk", "5.3.0", "45003240");

    private C1220rd() {
    }

    private final synchronized ExponentialBackoffDataHolder a(EnumC1197qd enumC1197qd) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        try {
            Map<EnumC1197qd, ExponentialBackoffDataHolder> map = a;
            exponentialBackoffDataHolder = map.get(enumC1197qd);
            if (exponentialBackoffDataHolder == null) {
                F0 f0G = F0.g();
                Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
                C0895e9 c0895e9S = f0G.s();
                Intrinsics.checkNotNullExpressionValue(c0895e9S, "GlobalServiceLocator.get…ance().servicePreferences");
                exponentialBackoffDataHolder = new ExponentialBackoffDataHolder(new C1173pd(c0895e9S, enumC1197qd));
                map.put(enumC1197qd, exponentialBackoffDataHolder);
            }
        } catch (Throwable th) {
            throw th;
        }
        return exponentialBackoffDataHolder;
    }

    @JvmStatic
    public static final NetworkTask a(Context context, ConfigProvider configProvider, C0836c0 c0836c0, E4 e4, C0819b8 c0819b8) {
        return new NetworkTask(new Gm(), new C1148od(context), new C1073ld(c.a(EnumC1197qd.DIAGNOSTIC)), new B4(configProvider, c0836c0, e4, c0819b8, new DefaultNetworkResponseHandler(), new RequestDataHolder(), new ResponseDataHolder(new C1123nd()), new FullUrlFormer(new Og(), configProvider)), CollectionsKt.listOf(A2.a()), b);
    }

    @JvmStatic
    public static final NetworkTask a(Context context, C0949gd c0949gd, C1233s2 c1233s2, Fc fc) {
        C1421zm c1421zm = new C1421zm();
        Pg pg = new Pg(c1421zm);
        C0 c0 = new C0(c0949gd);
        return new NetworkTask(new Gm(), new C1148od(context), new C1073ld(c.a(EnumC1197qd.LOCATION)), new C0849cd(context, c1233s2, fc, pg, c0, new RequestDataHolder(), new ResponseDataHolder(new C1123nd()), new FullUrlFormer(pg, c0), c1421zm), CollectionsKt.listOf(A2.a()), b);
    }

    @JvmStatic
    public static final NetworkTask a(L3 l3) {
        C1421zm c1421zm = new C1421zm();
        Qg qg = new Qg(c1421zm);
        C0862d1 c0862d1 = new C0862d1(l3);
        return new NetworkTask(new Gm(), new C1148od(l3.g()), new C1073ld(c.a(EnumC1197qd.REPORT)), new P1(l3, qg, c0862d1, new FullUrlFormer(qg, c0862d1), new RequestDataHolder(), new ResponseDataHolder(new C1123nd()), c1421zm), CollectionsKt.listOf(A2.a()), b);
    }

    @JvmStatic
    public static final NetworkTask a(C1225ri c1225ri, Mg mg) {
        Kg kg = new Kg();
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        Rg rg = new Rg(kg, f0G.j());
        C0 c0 = new C0(mg);
        return new NetworkTask(new Qm(), new C1148od(c1225ri.b()), new C1073ld(c.a(EnumC1197qd.STARTUP)), new C1186q2(c1225ri, new FullUrlFormer(rg, c0), new RequestDataHolder(), new ResponseDataHolder(new C1123nd()), c0), CollectionsKt.emptyList(), b);
    }
}
