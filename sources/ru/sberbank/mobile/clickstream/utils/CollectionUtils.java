package ru.sberbank.mobile.clickstream.utils;

import java.util.Collection;

/* loaded from: classes4.dex */
public final class CollectionUtils {
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
