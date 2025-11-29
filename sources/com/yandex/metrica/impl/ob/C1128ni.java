package com.yandex.metrica.impl.ob;

import com.yandex.metrica.IParamsCallback;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;

/* renamed from: com.yandex.metrica.impl.ob.ni, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1128ni {
    private static final Set<String> a = SetsKt.setOf((Object[]) new String[]{IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, "appmetrica_device_id_hash", "yandex_mobile_metrica_device_id", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url", "yandex_mobile_metrica_uuid"});
    private static TimeProvider b = new SystemTimeProvider();
    private static Rh c = new Rh();

    @JvmStatic
    public static final boolean a(long j) {
        return b.currentTimeSeconds() > j;
    }

    @JvmStatic
    public static final boolean b(C1178pi c1178pi) {
        if (!c1178pi.D()) {
            if (b.currentTimeSeconds() <= c1178pi.C() + c1178pi.O().a()) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean a(C1178pi c1178pi) {
        return a(c1178pi.V()) && a(c1178pi.i()) && a(c1178pi.j());
    }

    @JvmStatic
    public static final boolean a(String str) {
        return !(str == null || str.length() == 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a(com.yandex.metrica.impl.ob.C1178pi r3, java.util.Collection<java.lang.String> r4, java.util.Map<java.lang.String, java.lang.String> r5, kotlin.jvm.functions.Function0<com.yandex.metrica.impl.ob.I> r6) {
        /*
            r0 = 1
            if (r4 == 0) goto La1
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto Lb
            goto La1
        Lb:
            boolean r1 = r4 instanceof java.util.Collection
            if (r1 == 0) goto L17
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L17
            goto La1
        L17:
            java.util.Iterator r4 = r4.iterator()
        L1b:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto La1
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r1.hashCode()
            switch(r2) {
                case -220514361: goto L88;
                case 299713912: goto L77;
                case 530390881: goto L66;
                case 538565458: goto L51;
                case 1541938616: goto L40;
                case 1630523545: goto L2f;
                default: goto L2e;
            }
        L2e:
            goto L99
        L2f:
            java.lang.String r2 = "yandex_mobile_metrica_get_ad_url"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L99
            java.lang.String r1 = r3.p()
            boolean r1 = a(r1)
            goto L9e
        L40:
            java.lang.String r2 = "yandex_mobile_metrica_uuid"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L99
            java.lang.String r1 = r3.V()
            boolean r1 = a(r1)
            goto L9e
        L51:
            java.lang.String r2 = "yandex_mobile_metrica_clids"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L99
            com.yandex.metrica.impl.ob.Rh r1 = com.yandex.metrica.impl.ob.C1128ni.c
            java.lang.Object r2 = r6.invoke()
            com.yandex.metrica.impl.ob.I r2 = (com.yandex.metrica.impl.ob.I) r2
            boolean r1 = r1.a(r5, r3, r2)
            goto L9e
        L66:
            java.lang.String r2 = "yandex_mobile_metrica_report_ad_url"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L99
            java.lang.String r1 = r3.G()
            boolean r1 = a(r1)
            goto L9e
        L77:
            java.lang.String r2 = "appmetrica_device_id_hash"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L99
            java.lang.String r1 = r3.j()
            boolean r1 = a(r1)
            goto L9e
        L88:
            java.lang.String r2 = "yandex_mobile_metrica_device_id"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L99
            java.lang.String r1 = r3.i()
            boolean r1 = a(r1)
            goto L9e
        L99:
            boolean r1 = b(r3)
            r1 = r1 ^ r0
        L9e:
            if (r1 != 0) goto L1b
            r0 = 0
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1128ni.a(com.yandex.metrica.impl.ob.pi, java.util.Collection, java.util.Map, kotlin.jvm.functions.Function0):boolean");
    }

    @JvmStatic
    public static final Collection<String> a(Collection<String> collection) {
        return CollectionsKt.intersect(collection, a);
    }
}
