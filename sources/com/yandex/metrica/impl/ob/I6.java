package com.yandex.metrica.impl.ob;

import com.yandex.metrica.plugins.StackTraceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* loaded from: classes3.dex */
public final class I6 {
    @JvmStatic
    public static final H6 a(Throwable th, C1333w6 c1333w6, List<StackTraceElement> list, String str, Boolean bool) {
        ArrayList arrayList = null;
        F6 f6A = th != null ? G6.a(th) : null;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new D6((StackTraceElement) it.next()));
            }
        }
        return new H6(f6A, c1333w6, arrayList, null, null, null, str, bool);
    }

    @JvmStatic
    public static final H6 a(String str, String str2, List<? extends StackTraceItem> list, String str3, String str4, Map<String, String> map, String str5, Boolean bool) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (StackTraceItem stackTraceItem : list) {
                arrayList.add(new D6(stackTraceItem.getClassName(), stackTraceItem.getFileName(), stackTraceItem.getLine(), stackTraceItem.getColumn(), stackTraceItem.getMethodName(), null));
            }
        } else {
            arrayList = null;
        }
        return new H6(new F6(str, str2, arrayList, null, null), null, null, str3, str4, map, str5, bool);
    }
}
