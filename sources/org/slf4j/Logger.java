package org.slf4j;

/* loaded from: classes4.dex */
public interface Logger {
    void debug(String str);

    void debug(String str, Object obj);

    void debug(String str, Object obj, Object obj2);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    String getName();

    boolean isDebugEnabled();
}
