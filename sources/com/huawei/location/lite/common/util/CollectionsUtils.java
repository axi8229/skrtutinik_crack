package com.huawei.location.lite.common.util;

import java.util.Collection;

/* loaded from: classes3.dex */
public class CollectionsUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
