package ru.yoomoney.sdk.auth.utils;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesProvider;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"initThreeTen", "", "", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DateTimeExtensionsKt {
    public static final void initThreeTen(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (ZoneRulesProvider.getAvailableZoneIds().isEmpty()) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            InputStream resourceAsStream = classLoader.getResourceAsStream("TZDB.dat");
            try {
                TzdbZoneRulesProvider tzdbZoneRulesProvider = new TzdbZoneRulesProvider(resourceAsStream);
                CloseableKt.closeFinally(resourceAsStream, null);
                ZoneRulesProvider.registerProvider(tzdbZoneRulesProvider);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(resourceAsStream, th);
                    throw th2;
                }
            }
        }
    }
}
