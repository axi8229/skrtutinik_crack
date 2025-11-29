package ru.yoomoney.sdk.kassa.payments.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yandex.metrica.IReporter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
public final class i0 implements F {
    public final IReporter a;

    public i0(IReporter metrica) {
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        this.a = metrica;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.metrics.F
    public final void a(String name, String arg) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(arg, "arg");
        this.a.reportEvent(name, MapsKt.plus(MapsKt.mapOf(TuplesKt.to(arg, "")), MapsKt.mapOf(TuplesKt.to("msdkVersion", "7.0.0"))));
    }

    @Override // ru.yoomoney.sdk.kassa.payments.metrics.F
    public final void a(String name, List list) {
        Map mapEmptyMap;
        Intrinsics.checkNotNullParameter(name, "name");
        IReporter iReporter = this.a;
        if (list != null) {
            List<E> list2 = list;
            mapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (E e : list2) {
                Pair pair = TuplesKt.to(e.a(), e.b());
                mapEmptyMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        iReporter.reportEvent(name, MapsKt.plus(mapEmptyMap, MapsKt.mapOf(TuplesKt.to("msdkVersion", "7.0.0"))));
    }

    @Override // ru.yoomoney.sdk.kassa.payments.metrics.F
    public final void a(boolean z) {
        Intrinsics.checkNotNullParameter("close3dsScreen", AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.a.reportEvent("close3dsScreen", MapsKt.plus(MapsKt.mapOf(TuplesKt.to(String.valueOf(z), "")), MapsKt.mapOf(TuplesKt.to("msdkVersion", "7.0.0"))));
    }
}
