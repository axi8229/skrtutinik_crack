package flussonic.watcher.sdk.domain.utils;

import java.util.List;

/* loaded from: classes3.dex */
public class ObjectUtils {
    public static boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static <T> T getFirst(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }
}
