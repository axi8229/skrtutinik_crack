package org.slf4j.helpers;

/* loaded from: classes4.dex */
public class NOPLogger extends MarkerIgnoringBase {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    @Override // org.slf4j.Logger
    public final void debug(String str) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return false;
    }

    protected NOPLogger() {
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.Logger
    public String getName() {
        return "NOP";
    }
}
