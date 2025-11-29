package com.yandex.metrica.coreutils.collection;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/yandex/metrica/coreutils/collection/CollectionUtils;", "", "<init>", "()V", "", "", "", "input", "Landroid/os/Bundle;", "mapToBundle", "(Ljava/util/Map;)Landroid/os/Bundle;", "bundleToMap", "(Landroid/os/Bundle;)Ljava/util/Map;", "core-utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class CollectionUtils {
    public static final CollectionUtils INSTANCE = new CollectionUtils();

    private CollectionUtils() {
    }

    @JvmStatic
    public static final Bundle mapToBundle(Map<String, byte[]> input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Bundle bundle = new Bundle(input.size());
        for (Map.Entry<String, byte[]> entry : input.entrySet()) {
            bundle.putByteArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    @JvmStatic
    public static final Map<String, byte[]> bundleToMap(Bundle input) {
        HashMap map = new HashMap();
        if (input != null) {
            Set<String> setKeySet = input.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "it.keySet()");
            for (String key : setKeySet) {
                byte[] value = input.getByteArray(key);
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    map.put(key, value);
                }
            }
        }
        return map;
    }
}
