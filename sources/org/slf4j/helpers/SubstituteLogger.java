package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* loaded from: classes4.dex */
public class SubstituteLogger implements Logger {
    private volatile Logger _delegate;
    private final boolean createdPostInitialization;
    private Boolean delegateEventAware;
    private Queue<SubstituteLoggingEvent> eventQueue;
    private EventRecodingLogger eventRecodingLogger;
    private Method logMethodCache;
    private final String name;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.name = str;
        this.eventQueue = queue;
        this.createdPostInitialization = z;
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return delegate().isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public void debug(String str) {
        delegate().debug(str);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        delegate().debug(str, obj);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        delegate().debug(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object... objArr) {
        delegate().debug(str, objArr);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Throwable th) {
        delegate().debug(str, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.name.equals(((SubstituteLogger) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    Logger delegate() {
        if (this._delegate != null) {
            return this._delegate;
        }
        if (this.createdPostInitialization) {
            return NOPLogger.NOP_LOGGER;
        }
        return getEventRecordingLogger();
    }

    private Logger getEventRecordingLogger() {
        if (this.eventRecodingLogger == null) {
            this.eventRecodingLogger = new EventRecodingLogger(this, this.eventQueue);
        }
        return this.eventRecodingLogger;
    }

    public void setDelegate(Logger logger) {
        this._delegate = logger;
    }

    public boolean isDelegateEventAware() {
        Boolean bool = this.delegateEventAware;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.logMethodCache = this._delegate.getClass().getMethod("log", LoggingEvent.class);
            this.delegateEventAware = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.delegateEventAware = Boolean.FALSE;
        }
        return this.delegateEventAware.booleanValue();
    }

    public void log(LoggingEvent loggingEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (isDelegateEventAware()) {
            try {
                this.logMethodCache.invoke(this._delegate, loggingEvent);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public boolean isDelegateNull() {
        return this._delegate == null;
    }

    public boolean isDelegateNOP() {
        return this._delegate instanceof NOPLogger;
    }
}
