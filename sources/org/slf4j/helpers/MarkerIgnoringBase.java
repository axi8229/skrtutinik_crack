package org.slf4j.helpers;

import org.slf4j.Logger;

/* loaded from: classes4.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    @Override // org.slf4j.Logger
    public abstract /* bridge */ /* synthetic */ String getName();

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }
}
