package com.yandex.metrica.impl.ob;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.yandex.metrica.impl.ob.e1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0887e1 {
    private static final Pattern a = Pattern.compile("com\\.yandex\\.metrica\\.(?!push)");
    private static final Pattern b = Pattern.compile("com\\.yandex\\.metrica\\.push\\..*");

    public boolean a(List<StackTraceElement> list) {
        return a(list, a);
    }

    public boolean b(List<StackTraceElement> list) {
        return a(list, b);
    }

    private boolean a(List<StackTraceElement> list, Pattern pattern) {
        Iterator<StackTraceElement> it = list.iterator();
        while (it.hasNext()) {
            if (pattern.matcher(it.next().getClassName()).find()) {
                return true;
            }
        }
        return false;
    }
}
